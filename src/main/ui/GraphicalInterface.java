package ui;

import model.Exercise;
import model.WeeklyWorkout;
import model.Workout;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class GraphicalInterface extends JFrame implements ActionListener {
    private static final int WIDTH = 500;
    private static final int LENGTH = 700;
    private static final String JSON_STORE = "./data/WeeklyWorkout.json";  // Storage file location
    private JFrame frame;
    private JPanel panel;
    private JPanel listPane;
    private JPanel createExercisePane;
    private JPanel deleteExercisePlane;
    private JButton yesButton;
    private JButton noButton;
    private JButton begButton;
    private JButton intButton;
    private JButton advButton;
    private JButton mondayButton;
    private JButton tuesdayButton;
    private JButton wednesdayButton;
    private JButton thursdayButton;
    private JButton fridayButton;
    private JButton saturdayButton;
    private JButton sundayButton;
    private JButton saveButton;
    private JButton exitButton;
    private JButton button;
    private JButton addButton;
    private JButton deleteButton;
    private JButton menuButton;
    private JButton confirmDeleteButton;
    private JButton okButton1;
    private JButton numberMismatchButton;
    private JButton invalidBlankInputButton;
    private JButton saveConfirmButton;
    private JButton loadConfirmButton;
    private JButton exitConfirmButton;
    private JLabel recommendQ;
    private JLabel loadFileQuestion;
    private JLabel levelQ;
    private JLabel chooseDay;
    private JLabel emptyQ;
    private JLabel cannotFind;
    private JLabel success;
    private JLabel saveFile;
    private JLabel loadFile;
    private JLabel exitApp;
    private JLabel invalidBlankInput;
    private JLabel numberMismatchInput;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private WeeklyWorkout user;
    private JsonWriter jsonWriter;      // Save
    private JsonReader jsonReader;      // Load

    //MODIFIES: this
    //EFFECTS: initiate a new gui
    public GraphicalInterface() {
        user = new WeeklyWorkout();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        frame = new JFrame();
        panel = new JPanel();

        frame();
        panel();
        loadWorkoutQuestion();
        workoutQuestionButtons();
    }

    //MODIFIES: this
    //EFFECTS: sets the gui frame
    public void frame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, LENGTH);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
    }

    //MODIFIES: this
    //EFFECTS: create and add a new JLabel to frame
    public void loadWorkoutQuestion() {
        loadFileQuestion = new JLabel("Would you like to load a saved workout?");
        labelPositionCenter(loadFileQuestion);
        frame.add(loadFileQuestion);
    }

    //MODIFIES: this
    //EFFECTS: create and add two new button to panel
    public void workoutQuestionButtons() {
        yesButton = new JButton("Yes");
        noButton = new JButton("No");

        button(yesButton);
        button(noButton);

        panel.add(yesButton);
        panel.add(noButton);


        yesButton.addActionListener(this::workoutQuestionResult);
        noButton.addActionListener(this::workoutQuestionResult);
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void workoutQuestionResult(ActionEvent e) {
        if (e.getSource() == yesButton) {
            playSound();
            clearPanel();
            clearFrame(loadFileQuestion);
            loadWorkout();
            loadFile();
        } else if (e.getSource() == noButton) {
            playSound();
            clearFrame(loadFileQuestion);
            clearPanel();
            displayRecommendQuestion();
        }
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and two new buttons to add to frame and panel respectively
    public void displayRecommendQuestion() {
        recommendQ = new JLabel("Do you want to generate a recommended workout?");
        labelPositionCenter(recommendQ);
        frame.add(recommendQ);

        yesButton = new JButton("Yes");
        noButton = new JButton("No");

        button(yesButton);
        button(noButton);

        panel.add(yesButton);
        panel.add(noButton);

        yesButton.addActionListener(this::recommendQuestionResult);
        noButton.addActionListener(this::recommendQuestionResult);
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void recommendQuestionResult(ActionEvent e) {
        if (e.getSource() == yesButton) {
            playSound();
            clearFrame(recommendQ);
            clearPanel();
            askFitnessLevel();
        } else if (e.getSource() == noButton) {
            playSound();
            clearFrame(recommendQ);
            clearPanel();
            menu();
        }
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and three new buttons and add them to frame and panel respectively
    public void askFitnessLevel() {
        levelQ = new JLabel("What is your fitness level?");
        labelPositionCenter(levelQ);
        frame.add(levelQ);

        begButton = new JButton("Beginner (I can do <20 push-ups)");
        intButton = new JButton("Intermediate (I can do <50 push-ups)");
        advButton = new JButton("Advanced (I can do >50 push-ups)");

        button(begButton);
        button(intButton);
        button(advButton);

        panel.add(begButton);
        panel.add(intButton);
        panel.add(advButton);

        begButton.addActionListener(this::fitnessLevelResult);
        intButton.addActionListener(this::fitnessLevelResult);
        advButton.addActionListener(this::fitnessLevelResult);
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void fitnessLevelResult(ActionEvent e) {
        if (e.getSource() == begButton) {
            playSound();
            user.addBeginnerWorkout();
            clearFrame(levelQ);
            clearPanel();
            menu();
        } else if (e.getSource() == intButton) {
            playSound();
            user.addIntermediateWorkoutPushPull();
            user.addIntermediateWorkoutLegsCardio();
            clearFrame(levelQ);
            clearPanel();
            menu();
        } else if (e.getSource() == advButton) {
            playSound();
            user.addAdvancedWorkoutChestBack();
            user.addAdvancedWorkoutLegCardio();
            clearFrame(levelQ);
            clearPanel();
            menu();
        }
    }

    // Image source: https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.orion-fitness.com%2Fen%2Fproduct-
    // category%2Fservices%2F&psig=AOvVaw3fZX3j_vukKbxZVnGABtl-&ust=1605854346743000&source=images&cd=vfe&ved
    // =0CAMQjB1qFwoTCJj_5uL_je0CFQAAAAAdAAAAABAE
    //MODIFIES: this
    //EFFECTS: create a new JLabel and icon and add to frame; create seven main menu buttons and add to panel
    public void menu() {
        setButtons();
        chooseDay = new JLabel("Please select a day:");
        ImageIcon icon = new ImageIcon("./data/Workout5.jpg");
        chooseDay.setIcon(icon);
        labelPositionTop(chooseDay);
        chooseDay.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
        chooseDay.setVerticalTextPosition(JLabel.BOTTOM); //set text TOP,CENTER, BOTTOM of imageicon
        frame.add(chooseDay);

        panel.add(mondayButton);
        panel.add(tuesdayButton);
        panel.add(wednesdayButton);
        panel.add(thursdayButton);
        panel.add(fridayButton);
        panel.add(saturdayButton);
        panel.add(sundayButton);
        panel.add(saveButton);
        panel.add(exitButton);
    }

    //MODIFIES: this
    //EFFECTS: create a new panel named listPane and add to frame
    public void listPanel() {
        listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(Box.createRigidArea(new Dimension(0, 5)));
        frame.add(listPane);
        listPane.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: create JLabels for all exercises and add to listPane
    public void displayExercises(int i, Workout day) {
        clearFrame(chooseDay);
        listPanel();
        listPane.setVisible(true);
        clearPanel();
        exerciseButtons(i);
        if (day.getExercises().size() == 0) {
            clearPanel();
            emptyWorkoutQuestion(i);
        } else {
            for (Map.Entry<Integer, Exercise> integerExerciseEntry : day.getExercises().entrySet()) {
                int key = (int) ((Map.Entry) integerExerciseEntry).getKey();
                Exercise e = (Exercise) ((Map.Entry) integerExerciseEntry).getValue();
                JLabel label = new JLabel(key + ": " + e.getName()
                        + " for " + e.getSets() + " set(s) with " + e.getReps()
                        + " rep(s) per set");
                listPane.add(label);
            }
            listPane.revalidate();
        }
    }

    //MODIFIES: this
    //EFFECTS: create new JLabel and two new buttons and add them to frame and panel respectively
    public void emptyWorkoutQuestion(int i) {
        emptyQ = new JLabel("Workout is empty, do you want to add an exercise?");
        labelPositionCenter(emptyQ);
        frame.add(emptyQ);
        frame.revalidate();

        yesButton = new JButton("Yes");
        noButton = new JButton("No");

        button(yesButton);
        button(noButton);

        panel.add(yesButton);
        panel.add(noButton);

        yesButton.addActionListener(event -> emptyWorkoutResult(event, i));
        noButton.addActionListener(event -> emptyWorkoutResult(event, i));
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void emptyWorkoutResult(ActionEvent e, int i) {
        if (e.getSource() == yesButton) {
            playSound();
            clearPanel();
            clearFrame(emptyQ);
            listPane.setVisible(false);
            createExercise(i);
        } else if (e.getSource() == noButton) {
            playSound();
            clearPanel();
            clearFrame(emptyQ);
            menu();
        }
    }

    //MODIFIES: this
    //EFFECTS: create a panel and add a button, three new JLabels, three new Textfields to it
    public void createExercise(int i) {
        createExercisePane = new JPanel();
        createExercisePane.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 100));

        button = new JButton("Confirm");
        button(button);

        JLabel createQ1 = new JLabel("Please enter exercise name:");
        JLabel createQ2 = new JLabel("Please enter exercise set number:");
        JLabel createQ3 = new JLabel("Please enter exercise repetition number:");

        textField1 = new JTextField(15);
        textField1.setMaximumSize(textField1.getPreferredSize());
        textField2 = new JTextField(15);
        textField2.setMaximumSize(textField2.getPreferredSize());
        textField3 = new JTextField(15);
        textField3.setMaximumSize(textField3.getPreferredSize());

        createExercisePane.add(createQ1);
        createExercisePane.add(textField1);
        createExercisePane.add(createQ2);
        createExercisePane.add(textField2);
        createExercisePane.add(createQ3);
        createExercisePane.add(textField3);

        frame.add(createExercisePane);
        panel.add(button);
        createExercisePane.revalidate();

        button.addActionListener(event -> createExerciseResult(event, i));
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void createExerciseResult(ActionEvent e, int i) {
        try {
            if (e.getSource() == button) {
                playSound();
                String name = textField1.getText();
                int sets = Integer.parseInt(textField2.getText());
                int reps = Integer.parseInt(textField3.getText());
                if (name.equals("")) {
                    throw new IllegalArgumentException();
                } else if (sets < 1 || reps < 1) {
                    throw new IllegalArgumentException();
                }
                createExerciseResultHelper(i, sets, reps, name);
            }
        } catch (NumberFormatException ex) {
            createExerciseResultHelper();
            inputMismatchException(i);
        } catch (IllegalArgumentException ex) {
            createExerciseResultHelper();
            invalidInputException(i);
        }
    }

    //MODIFIES: this
    //EFFECTS: helper to shorten createExerciseResult
    public void createExerciseResultHelper() {
        createExercisePane.setVisible(false);
        clearPanel();
    }

    //MODIFIES: this
    //EFFECTS: helper to shorten createExerciseResult
    public void createExerciseResultHelper(int i, int sets, int reps, String name) {
        user.generateNewWorkout(i, name, sets, reps);
        clearPanel();
        createExercisePane.removeAll();
        panel.revalidate();
        panel.repaint();
        createExercisePane.setVisible(false);
        exerciseButtons(i);
        displayDayHelper(i);
    }

    //MODIFIES: this
    //EFFECTS: add a new JLabel and button to frame and panel respectively
    public void inputMismatchException(int i) {
        numberMismatchInput = new JLabel("Input not valid...");
        labelPositionCenter(numberMismatchInput);
        numberMismatchButton = new JButton("Ok");
        button(numberMismatchButton);
        frame.add(numberMismatchInput);
        panel.add(numberMismatchButton);

        numberMismatchButton.addActionListener(event -> inputMismatchExceptionResult(event, i));
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void inputMismatchExceptionResult(ActionEvent e, int i) {
        if (e.getSource() == numberMismatchButton) {
            playSound();
            clearPanel();
            clearFrame(numberMismatchInput);
            exerciseButtons(i);
            displayDayHelper(i);
        }
    }


    //MODIFIES: this
    //EFFECTS: add a new JLabel and button to frame and panel respectively
    public void invalidInputException(int i) {
        invalidBlankInput = new JLabel("Input not valid...");
        labelPositionCenter(invalidBlankInput);
        invalidBlankInputButton = new JButton("Ok");
        button(invalidBlankInputButton);
        frame.add(invalidBlankInput);
        panel.add(invalidBlankInputButton);

        invalidBlankInputButton.addActionListener(event -> invalidInputExceptionResult(event, i));
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void invalidInputExceptionResult(ActionEvent e, int i) {
        if (e.getSource() == invalidBlankInputButton) {
            playSound();
            clearPanel();
            clearFrame(invalidBlankInput);
            exerciseButtons(i);
            displayDayHelper(i);
        }
    }

    //MODIFIES: this
    //EFFECTS: create three new buttons and add them to panel
    public void exerciseButtons(int i) {
        addButton = new JButton("Add another exercise");
        deleteButton = new JButton("Delete an exercise");
        menuButton = new JButton("Menu");

        button(addButton);
        button(deleteButton);
        button(menuButton);

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(menuButton);

        addButton.addActionListener(event -> exerciseButtonResult(event, i));
        deleteButton.addActionListener(event -> exerciseButtonResult(event, i));
        menuButton.addActionListener(event -> exerciseButtonResult(event, i));
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void exerciseButtonResult(ActionEvent e, int i) {
        if (e.getSource() == addButton) {
            playSound();
            clearPanel();
            listPane.setVisible(false);
            createExercise(i);
        } else if (e.getSource() == deleteButton) {
            playSound();
            clearPanel();
            listPane.setVisible(false);
            deleteExercise(i);
        } else if (e.getSource() == menuButton) {
            playSound();
            clearPanel();
            listPane.removeAll();
            listPane.setVisible(false);
            menu();
        }
    }

    //MODIFIES: this
    //EFFECTS: create a panel and add a new button, a new JLabels, a new Textfields to it
    public void deleteExercise(int i) {
        deleteExercisePlane = new JPanel();
        deleteExercisePlane.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 100));
        confirmDeleteButton = new JButton("Confirm");
        button(confirmDeleteButton);

        JLabel createQ4 = new JLabel("Please enter the number of an exercise you want to delete:");

        textField4 = new JTextField(15);
        textField4.setMaximumSize(textField4.getPreferredSize());

        deleteExercisePlane.add(createQ4);
        deleteExercisePlane.add(textField4);

        frame.add(deleteExercisePlane);
        panel.add(confirmDeleteButton);
        deleteExercisePlane.revalidate();

        confirmDeleteButton.addActionListener(event -> deleteExerciseResult(event, i));
    }

    //MODIFIES: this
    //EFFECTS: create a new button and process user input
    public void deleteExerciseResult(ActionEvent e, int i) {
        okButton1 = new JButton("Ok");
        button(okButton1);
        deleteExercisePlane.removeAll();
        deleteExercisePlane.setVisible(false);
        clearPanel();
        if (e.getSource() == confirmDeleteButton) {
            playSound();
            try {
                if (user.lookForExercise(i, Integer.parseInt(textField4.getText()))) {
                    cannotFindExercise();
                    panel.add(okButton1);
                    okButton1.addActionListener(event -> okButtonResult(event, i, 0));
                } else {
                    user.removeWorkout(i, Integer.parseInt(textField4.getText()));
                    sucessfullyDeleted();
                    panel.add(okButton1);
                    okButton1.addActionListener(event -> okButtonResult(event, i, 1));
                }
            } catch (NumberFormatException ex) {
                inputMismatchException(i);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void okButtonResult(ActionEvent e, int i, int num) {
        if (e.getSource() == okButton1) {
            playSound();
            if (num == 0) {
                clearFrame(cannotFind);
            } else {
                clearFrame(success);
            }
            exerciseButtons(i);
            displayDayHelper(i);
        }
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and add to frame
    public void cannotFindExercise() {
        cannotFind = new JLabel("Selection not found...");
        labelPositionCenter(cannotFind);
        frame.add(cannotFind);
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and add to frame
    public void sucessfullyDeleted() {
        success = new JLabel("Successfully deleted");
        labelPositionCenter(success);
        frame.add(success);
    }

    //MODIFIES: this
    //EFFECTS: helper to shorten displayDay
    public void displayDayHelper(int i) {
        if (i == 1) {
            displayMondayExercises();
        } else if (i == 2) {
            displayTuesdayExercises();
        } else if (i == 3) {
            displayWednesdayExercises();
        } else if (i == 4) {
            displayThursdayExercises();
        } else if (i == 5) {
            displayFridayExercises();
        } else if (i == 6) {
            displaySaturdayExercises();
        } else if (i == 7) {
            displaySundayExercises();
        }
    }

    //MODIFIES: this
    //EFFECTS: display all monday exercises
    public void displayMondayExercises() {
        int i = 1;
        Workout monday = user.getMonday();
        displayExercises(i, monday);
    }

    //MODIFIES: this
    //EFFECTS: display all tuesday exercises
    public void displayTuesdayExercises() {
        int i = 2;
        Workout tuesday = user.getTuesday();
        displayExercises(i, tuesday);
    }

    //MODIFIES: this
    //EFFECTS: display all wednesday exercises
    public void displayWednesdayExercises() {
        int i = 3;
        Workout wednesday = user.getWednesday();
        displayExercises(i, wednesday);
    }

    //MODIFIES: this
    //EFFECTS: display all thursday exercises
    public void displayThursdayExercises() {
        int i = 4;
        Workout thursday = user.getThursday();
        displayExercises(i, thursday);
    }

    //MODIFIES: this
    //EFFECTS: display all friday exercises
    public void displayFridayExercises() {
        int i = 5;
        Workout friday = user.getFriday();
        displayExercises(i, friday);
    }

    //MODIFIES: this
    //EFFECTS: display all saturday exercises
    public void displaySaturdayExercises() {
        int i = 6;
        Workout saturday = user.getSaturday();
        displayExercises(i, saturday);
    }

    //MODIFIES: this
    //EFFECTS: display all sunday exercises
    public void displaySundayExercises() {
        int i = 7;
        Workout sunday = user.getSunday();
        displayExercises(i, sunday);
    }

    //MODIFIES: this
    //EFFECTS: modify button characteristics
    public void button(JButton button) {
        button.setFocusable(false);
        button.setFont(new Font("Ariel", Font.BOLD, 15));
        button.setForeground(new Color(0xC9A04A));
        button.setBackground(new Color(0x5F526D));
    }

    //EFFECTS: create a new button
    public void setMondayButton() {
        mondayButton = new JButton("Monday");
        button(mondayButton);
        mondayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setTuesdayButton() {
        tuesdayButton = new JButton("Tuesday");
        button(tuesdayButton);
        tuesdayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setWednesdayButton() {
        wednesdayButton = new JButton("Wednesday");
        button(wednesdayButton);
        wednesdayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setThursdayButton() {
        thursdayButton = new JButton("Thursday");
        button(thursdayButton);
        thursdayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setFridayButton() {
        fridayButton = new JButton("Friday");
        button(fridayButton);
        fridayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setSaturdayButton() {
        saturdayButton = new JButton("Saturday");
        button(saturdayButton);
        saturdayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setSundayButton() {
        sundayButton = new JButton("Sunday");
        button(sundayButton);
        sundayButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setSaveButton() {
        saveButton = new JButton("Save");
        button(saveButton);
        saveButton.addActionListener(this);
    }

    //EFFECTS: create a new button
    public void setExitButton() {
        exitButton = new JButton("Exit");
        button(exitButton);
        exitButton.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: modifies panel layout
    public void panel() {
        panel.setBounds(0, 442, WIDTH - 5, LENGTH / 3);
        panel.setLayout(new GridLayout(0, 1));
    }

    //MODIFIES: this
    //EFFECTS: process user input
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mondayButton) {
            playSound();
            displayMondayExercises();
        } else if (e.getSource() == tuesdayButton) {
            playSound();
            displayTuesdayExercises();
        } else if (e.getSource() == wednesdayButton) {
            playSound();
            displayWednesdayExercises();
        } else if (e.getSource() == thursdayButton) {
            playSound();
            displayThursdayExercises();
        } else if (e.getSource() == fridayButton) {
            playSound();
            displayFridayExercises();
        } else {
            actionPerformedHelper(e);
        }
    }

    //MODIFIES: this
    //EFFECTS: helper to shorten actionPerformed
    public void actionPerformedHelper(ActionEvent e) {
        if (e.getSource() == saturdayButton) {
            playSound();
            displaySaturdayExercises();
        } else if (e.getSource() == sundayButton) {
            playSound();
            displaySundayExercises();
        } else if (e.getSource() == saveButton) {
            playSound();
            actionPerformedHelper();
            saveWorkout();
            saveFile();
        } else if (e.getSource() == exitButton) {
            playSound();
            actionPerformedHelper();
            exitApp();
        }
    }

    //MODIFIES: this
    //EFFECTS: helper to shorten actionPerformed
    public void actionPerformedHelper() {
        clearPanel();
        clearFrame(chooseDay);
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and button and add them to frame and panel respectively
    public void exitApp() {
        exitApp =
                new JLabel("<html>“The resistance that you fight physically in the gym and the resistance that you "
                        + "fight in life can only build a strong character.” \n– Arnold Schwarzenegger<html>");
        exitConfirmButton = new JButton("Exit");
        button(exitConfirmButton);

        labelPositionCenter(exitApp);
        frame.add(exitApp);
        panel.add(exitConfirmButton);

        exitConfirmButton.addActionListener(this::exitAppResult);
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void exitAppResult(ActionEvent e) {
        if (e.getSource() == exitConfirmButton) {
            playSound();
            clearFrame(exitApp);
            clearPanel();
            System.exit(0);
        }
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and button and add the mto frame and panel respectively
    public void saveFile() {
        saveFile = new JLabel("Saved " + "workout data" + " to " + JSON_STORE);
        saveConfirmButton = new JButton("Ok");
        button(saveConfirmButton);

        labelPositionCenter(saveFile);
        frame.add(saveFile);
        panel.add(saveConfirmButton);

        saveConfirmButton.addActionListener(this::saveFileResult);
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void saveFileResult(ActionEvent e) {
        if (e.getSource() == saveConfirmButton) {
            playSound();
            clearFrame(saveFile);
            clearPanel();
            menu();
        }
    }

    //MODIFIES: this
    //EFFECTS: create a new JLabel and button and add the mto frame and panel respectively
    public void loadFile() {
        loadFile = new JLabel("Loaded " + "workout data" + " from " + JSON_STORE);
        loadConfirmButton = new JButton("Ok");
        button(loadConfirmButton);

        labelPositionCenter(loadFile);
        frame.add(loadFile);
        panel.add(loadConfirmButton);

        loadConfirmButton.addActionListener(this::loadFileResult);
    }

    //MODIFIES: this
    //EFFECTS: process user input
    public void loadFileResult(ActionEvent e) {
        if (e.getSource() == loadConfirmButton) {
            playSound();
            clearFrame(loadFile);
            clearPanel();
            menu();
        }
    }

    // Code Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves the WeeklyWorkout to file
    private void saveWorkout() {
        try {
            jsonWriter.open();
            jsonWriter.write(user);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // Code Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads WeeklyWorkout from file
    private void loadWorkout() {
        try {
            user = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: create all buttons for menu
    public void setButtons() {
        setMondayButton();
        setTuesdayButton();
        setWednesdayButton();
        setThursdayButton();
        setFridayButton();
        setSaturdayButton();
        setSundayButton();
        setSaveButton();
        setExitButton();
    }

    // MODIFIES: this
    // EFFECTS: remove label from frame
    public void clearFrame(JLabel label) {
        frame.remove(label);
        frame.revalidate();
        frame.repaint();
    }

    // MODIFIES: this
    // EFFECTS: remove everything from panel
    public void clearPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    // MODIFIES: this
    // EFFECTS: center label in frame
    public void labelPositionCenter(JLabel label) {
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: place label top of frame
    public void labelPositionTop(JLabel label) {
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    // SOURCE: https://youtu.be/TErboGLHZGA
    // MODIFIES: this
    // EFFECTS: play selected sound
    public void playSound() {
        File musicPath = new File("./data/clicksoundeffect.wav");
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}

