package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an exercise having a name, sets, and repetitions.
public class Exercise implements Writable {

    String name; // exercise name
    int sets; // recommended sets for exercise
    int reps; // recommended repetitions for exercise

    //    REQUIRES: name has a non-zero length; sets and reps must be > 0
    //    EFFECTS: create a new exercise;
    //             exercise name is set to name;
    //             exercise sets set to sets(parameter);
    //             exercise reps set to reps(parameter).
    public Exercise(String name, int sets, int reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sets", sets);
        json.put("reps", reps);
        return json;
    }
}
