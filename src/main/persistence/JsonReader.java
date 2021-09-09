package persistence;

import model.Exercise;
import model.WeeklyWorkout;
import model.Workout;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads WeeklyWorkout from JSON data stored in file
public class JsonReader {
    private String source;  // Source file

    // Code Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // Code Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: reads WeeklyWorkout from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WeeklyWorkout read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWeeklyWorkout(jsonObject);
    }

    // Code Citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses WeeklyWorkout(we) from JSON object and returns it
    private WeeklyWorkout parseWeeklyWorkout(JSONObject jsonObject) {
        WeeklyWorkout we = new WeeklyWorkout();

        JSONArray jsonArray = jsonObject.getJSONArray("we");
        int i = 0;
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(we, nextWorkout, i);
            i++;
        }
        return we;
    }

    // EFFECTS: parses Workouts from JSON object and pass them to addExercise
    private void addWorkout(WeeklyWorkout we, JSONObject jsonObject, int i) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(we, nextExercise, i);
        }
    }


    // EFFECTS: parses Exercise from JSON object and adds it to WeeklyWorkout(we)
    private void addExercise(WeeklyWorkout we, JSONObject jsonObject, int i) {
        String name = jsonObject.getString("name");
        Integer sets = jsonObject.getInt("sets");
        Integer reps = jsonObject.getInt("reps");
        addExerciseHelper(we, name, sets, reps, i);
    }

    // MODIFIES: wr
    // EFFECTS: add an exercise with name, sets, and reps to correct day of the week in WeeklyWorkout(we)
    public void addExerciseHelper(WeeklyWorkout we, String name, int sets, int reps, int i) {

        switch (i) {
            case 0:
                we.getMonday().addExercise(name, sets, reps);
                break;
            case 1:
                we.getTuesday().addExercise(name, sets, reps);
                break;
            case 2:
                we.getWednesday().addExercise(name, sets, reps);
                break;
            case 3:
                we.getThursday().addExercise(name, sets, reps);
                break;
            case 4:
                we.getFriday().addExercise(name, sets, reps);
                break;
            case 5:
                we.getSaturday().addExercise(name, sets, reps);
                break;
            default:
                we.getSunday().addExercise(name, sets, reps);
                break;
        }
    }
}

