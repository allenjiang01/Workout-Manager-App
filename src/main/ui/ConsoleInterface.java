package ui;

import model.Exercise;
import model.WeeklyWorkout;
import model.Workout;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

// Workout Manager Application
public class ConsoleInterface {

    private Scanner input;         // Stores user input
    private WeeklyWorkout user;    // Stores user workout data
    private JsonWriter jsonWriter;      // Save
    private JsonReader jsonReader;      // Load
    private static final String JSON_STORE = "./data/WeeklyWorkout.json";  // Storage file location


    // runs the workout application
    public ConsoleInterface() {
        runApp();
    }


    // Code citation: TellerApp
    // MODIFIES: this
    // EFFECTS: processes user input
    public void runApp() {
        String userInput = null;
        Boolean ifTrue = true;

        initWorkout();
        System.out.println("\nHello");
        loadWorkoutQuestion();
        displayRecommendQuestion();
        userInput = input.next();
        userInput = userInput.toLowerCase();
        while (ifTrue) {
            if (!(userInput.equals("y") || userInput.equals("n"))) {
                System.out.println("\nSelection not valid...");
                runApp();
            } else {
                processQuestion(userInput);
            }
            ifTrue = false;
        }
    }

    // MODIFIES: this
    // EFFECTS: displays load workout question and processes user input
    public void loadWorkoutQuestion() {
        String userInput = null;
        System.out.println("\nWould you like to load a saved workout?");
        System.out.println("\ty -> Yes");
        System.out.println("\tn -> No");

        userInput = input.next();
        userInput = userInput.toLowerCase();

        if (userInput.equals("y")) {
            loadWorkout();
            displayWorkout();
            createWorkout();
        } else if (!userInput.equals("n")) {
            System.out.println("\nSelection not valid...");
            loadWorkoutQuestion();
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void processQuestion(String userInput) {
        if (userInput.equals("n")) {
            displayWorkout();
            createWorkout();

        } else {
            displayLevelQuestion();
            askLevel();
        }
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    public void askLevel() {
        String userInput = null;
        userInput = input.next();
        userInput = userInput.toLowerCase();

        if (userInput.equals("b")) {
            user.addBeginnerWorkout();
            displayWorkout();
            createWorkout();
        } else if (userInput.equals("i")) {
            user.addIntermediateWorkoutPushPull();
            user.addIntermediateWorkoutLegsCardio();
            displayWorkout();
            createWorkout();
        } else if (userInput.equals("a")) {
            user.addAdvancedWorkoutChestBack();
            user.addAdvancedWorkoutLegCardio();
            displayWorkout();
            createWorkout();
        } else {
            System.out.println("\nSelection not valid...");
            displayLevelQuestion();
            askLevel();
        }
    }


    // MODIFIES: this
    // EFFECTS: initializes workout
    public void initWorkout() {
        input = new Scanner(System.in);
        user = new WeeklyWorkout();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }


    // EFFECTS: displays user made workout (Days)
    public void displayWorkout() {
        System.out.println("\nPlease select a day:");
        System.out.println("\t1 -> Monday");
        System.out.println("\t2 -> Tuesday");
        System.out.println("\t3 -> Wednesday");
        System.out.println("\t4 -> Thursday");
        System.out.println("\t5 -> Friday");
        System.out.println("\t6 -> Saturday");
        System.out.println("\t7 -> Sunday");
        System.out.println("\t8 -> Save Workout");
        System.out.println("\t9 -> Exit");
    }


    // EFFECTS: displays options for pre-made workouts to user
    public void displayRecommendQuestion() {
        System.out.println("\nDo you want to generate a recommended workout?");
        System.out.println("\ty -> Yes");
        System.out.println("\tn -> No");
    }


    // EFFECTS: displays menu of fitness level options to user
    public void displayLevelQuestion() {
        System.out.println("\nWhat is your fitness level?");
        System.out.println("\tb -> Beginner (I can do <20 push-ups)");
        System.out.println("\ti -> Intermediate (I can do <50 push-ups)");
        System.out.println("\ta -> Advanced (I can do >50 push-ups)");
    }


    // EFFECTS: display menu of options to user
    public void displayWorkoutOptions() {
        System.out.println("\na -> Add another exercise");
        System.out.println("\nd -> Delete an exercise");
        System.out.println("\nr -> Return to menu");
    }


    // EFFECTS: display options to add exercise to an empty list to user
    public void displayEmptyWorkoutOptions() {
        System.out.println("\nWorkout is empty, do you want to add an exercise?");
        System.out.println("\ty -> Yes");
        System.out.println("\tn -> No");
    }


    // REQUIRES: userInput must be int
    // MODIFIES: this
    // EFFECTS: process user input
    public void createWorkout() {
        int userInput = 0;
        try {
            userInput = parseInt(input.next());
            createWorkoutConditionHelper(userInput);
        } catch (NumberFormatException e) {
            createWorkoutHelper();
        }
    }

    // EFFECTS: process user input
    public void createWorkoutConditionHelper(int userInput) {
        if (userInput == 1) {
            displayMonday();
        } else if (userInput == 2) {
            displayTuesday();
        } else if (userInput == 3) {
            displayWednesday();
        } else if (userInput == 4) {
            displayThursday();
        } else if (userInput == 5) {
            displayFriday();
        } else if (userInput == 6) {
            displaySaturday();
        } else if (userInput == 7) {
            displaySunday();
        } else if (userInput == 8) {
            saveWorkout();
            displayWorkout();
            createWorkout();
        } else if (userInput == 9) {
            exitApp();
        } else {
            createWorkoutHelper();
        }
    }

    // EFFECTS: repeats menu
    private void createWorkoutHelper() {
        System.out.println("\nSelection not valid...");
        displayWorkout();
        createWorkout();
    }


    // MODIFIES: this
    // EFFECTS: process user input
    public void emptyWorkoutQuestion(int i) {
        String userInput = null;

        displayEmptyWorkoutOptions();

        userInput = input.next();
        userInput = userInput.toLowerCase();

        if (userInput.equals("y")) {
            input.nextLine();
            addExercise(i);
        } else {
            if (userInput.equals("n")) {
                displayWorkout();
                createWorkout();
            } else {
                System.out.println("\nSelection not valid...");
                emptyWorkoutQuestion(i);
            }
        }
    }


    // MODIFIES: this
    // EFFECTS: add an exercise
    public void addExercise(int i) {
        String userInputString = null;
        int userInputInt1 = 0;
        int userInputInt2 = 0;

        System.out.println("\nPlease enter exercise name:");
        userInputString = input.nextLine();
        if (userInputString.equals("")) {
            throw new IllegalArgumentException();
        }
        String name = userInputString;

        try {
            System.out.println("\nPlease enter exercise set number:");
            int set = addSet(userInputInt1, i);

            System.out.println("\nPlease enter exercise repetition number:");
            int rep = addRep(userInputInt2, i);

            user.generateNewWorkout(i, name, set, rep);
            returnDayDisplay(i);

        } catch (InputMismatchException e) {
            addExerciseInputMismatchHelper(i);
        } catch (IllegalArgumentException e) {
            System.out.println("\nPlease enter a non empty name!");
            addExercise(i);
        }
    }

    // EFFECTS: helper to shorten input mismatch exception case in addExercise
    private void addExerciseInputMismatchHelper(int i) {
        System.out.println("\nSelection not valid...");
        input.nextLine();
        addExercise(i);
    }

    // MODIFIES: this
    // EFFECTS: add sets to a new exercise
    private int addSet(int userInputInt1, int i) {
        userInputInt1 = input.nextInt();
        try {
            if (userInputInt1 < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nPlease enter a positive Value!");
            input.nextLine();
            addExercise(i);
        }
        return userInputInt1;
    }


    // MODIFIES: this
    // EFFECTS: add repetitions to a new exercise
    private int addRep(int userInputInt2, int i) {
        userInputInt2 = input.nextInt();
        try {
            if (userInputInt2 < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nPlease enter a positive Value!");
            input.nextLine();
            addExercise(i);
        }
        return userInputInt2;
    }


    // EFFECTS: display correct day menu to user
    public void returnDayDisplay(int i) {
        if (i == 1) {
            displayMonday();
        } else if (i == 2) {
            displayTuesday();
        } else if (i == 3) {
            displayWednesday();
        } else if (i == 4) {
            displayThursday();
        } else if (i == 5) {
            displayFriday();
        } else if (i == 6) {
            displaySaturday();
        } else if (i == 7) {
            displaySunday();
        }
    }

    // EFFECTS: process user input
    public void exerciseOptions(int i) {
        String userInput = null;
        userInput = input.next();

        if (userInput.equals("r")) {
            displayWorkout();
            createWorkout();
        } else {
            if (userInput.equals("d")) {
                deleteExercise(i);
            } else {
                if (userInput.equals("a")) {
                    input.nextLine();
                    addExercise(i);
                } else {
                    System.out.println("\nSelection not valid...");
                    displayWorkoutOptions();
                    exerciseOptions(i);
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: delete an exercise
    public void deleteExercise(int i) {
        System.out.println("\nPlease enter the number of an exercise you want to delete:");
        int userInputString = 0;
        input.nextLine();
        try {
            userInputString = Integer.parseInt(input.nextLine());

            if (user.lookForExercise(i, userInputString)) {
                System.out.println("\nSelection not found...");
            } else {
                user.removeWorkout(i, userInputString);
                System.out.println("\nSuccessfully deleted");
            }
            returnDayDisplay(i);
        } catch (NumberFormatException e) {
            System.out.println("\nSelection not valid...");
            returnDayDisplay(i);
        }
    }


    // EFFECTS: exit the app
    public void exitApp() {
        System.out.println("“The resistance that you fight physically in the gym and the resistance that you "
                + "fight in life can only build a strong character.” \n– Arnold Schwarzenegger");
        System.exit(0);
    }


    // EFFECTS: display all exercises for Monday
    public void displayMonday() {
        int i = 1;
        Workout monday = user.getMonday();
        displayDayHelper(i, monday);
    }


    // EFFECTS: display all exercises for Tuesday
    public void displayTuesday() {
        int i = 2;
        Workout tuesday = user.getTuesday();
        displayDayHelper(i, tuesday);
    }


    // EFFECTS: display all exercises for Wednesday
    public void displayWednesday() {
        int i = 3;
        Workout wednesday = user.getWednesday();
        displayDayHelper(i, wednesday);
    }


    // EFFECTS: display all exercises for Thursday
    public void displayThursday() {
        int i = 4;
        Workout thursday = user.getThursday();
        displayDayHelper(i, thursday);
    }


    // EFFECTS: display all exercises for Friday
    public void displayFriday() {
        int i = 5;
        Workout friday = user.getFriday();
        displayDayHelper(i, friday);
    }


    // EFFECTS: display all exercises for Saturday
    public void displaySaturday() {
        int i = 6;
        Workout saturday = user.getSaturday();
        displayDayHelper(i, saturday);
    }


    // EFFECTS: display all exercises for Sunday
    public void displaySunday() {
        int i = 7;
        Workout sunday = user.getSunday();
        displayDayHelper(i, sunday);
    }

    // SOURCE: https://stackoverflow.com/questions/4234985/how-to-for-each-the-hashmap
    // EFFECTS: display all exercises for a particular day
    private void displayDayHelper(int i, Workout day) {
        if (day.getExercises().size() == 0) {
            emptyWorkoutQuestion(i);
        } else {
            System.out.println("\nYour workout is:");
            day.getExercises().forEach((key, e) -> System.out.println("\n" + key + ": " + e.getName()
                    + " for " + e.getSets() + " set(s) with " + e.getReps()
                    + " rep(s) per set"));
        }
        displayWorkoutOptions();
        exerciseOptions(i);
    }


    // Code Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves the WeeklyWorkout to file
    private void saveWorkout() {
        try {
            jsonWriter.open();
            jsonWriter.write(user);
            jsonWriter.close();
            System.out.println("Saved " + "workout data" + " to " + JSON_STORE);
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
            System.out.println("Loaded " + "workout data" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}



