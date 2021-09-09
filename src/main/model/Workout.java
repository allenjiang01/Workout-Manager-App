package model;

import java.util.*;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Represents a workout made up of a list of exercises
public class Workout implements Preset, Writable {

    Exercise exercise;           // exercise
    HashMap<Integer, Exercise> exercises;    // list of exercise

    // EFFECTS: create a new empty list of exercises
    public Workout() {
        exercises = new HashMap<>();
    }


    // REQUIRES: name has a non-zero length; sets and reps are int > 0
    // MODIFIES: this
    // EFFECTS: add an exercise to this
    public void addExercise(String name, int sets, int reps) {
        int key = exercises.size() + 1;
        exercise = new Exercise(name, sets, reps);
        exercises.put(key, exercise);
    }

    // MODIFIES: this
    // EFFECTS: look through exercises; remove any exercise with entry key = key and reposition all other exercises
    public void removeExercise(int key) {
        List<Exercise> tempEx = new LinkedList<>();
        List<Integer> tempCount = new LinkedList<>();
        exercises.remove(key);
        for (Map.Entry<Integer, Exercise> integerExerciseEntry : exercises.entrySet()) {
            int count = (int) ((Map.Entry) integerExerciseEntry).getKey();
            if (count > key) {
                Exercise e = (Exercise) ((Map.Entry) integerExerciseEntry).getValue();
                tempEx.add(e);
                tempCount.add(count);
            }
        }
        for (Integer i : tempCount) {
            exercises.remove(i);
        }
        for (Exercise ex : tempEx) {
            exercises.put(key, ex);
            key = key + 1;
        }
    }

    // EFFECTS: look through exercises, return true if key matches any exercise
    //          key, false if none are found
    public boolean canFind(int key) {
        boolean count = false;
        for (Map.Entry<Integer, Exercise> integerExerciseEntry : exercises.entrySet()) {
            if (((Map.Entry) integerExerciseEntry).getKey().equals(key)) {
                count = true;
                break;
            }
        }
        return count;
    }

    public HashMap<Integer, Exercise> getExercises() {
        return exercises;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("exercises", exercisesToJson());
        return json;
    }

    // SOURCE: https://stackoverflow.com/questions/17444396/putting-hashmapstring-object-in-jsonobject
    // EFFECTS: returns exercise in this exercises as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<Integer, Exercise> integerExerciseEntry : exercises.entrySet()) {
            Exercise e = (Exercise) ((Map.Entry) integerExerciseEntry).getValue();
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }
}


