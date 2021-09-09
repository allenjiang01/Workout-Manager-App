package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.LinkedList;
import java.util.List;


// Represents a week (Monday to Sunday) of workouts
public class WeeklyWorkout implements Preset, Writable {
    List<Workout> we;    // stores all days of the week
    Workout monday;      // stores Monday workout
    Workout tuesday;     // stores Tuesday workout
    Workout wednesday;   // stores Wednesday workout
    Workout thursday;    // stores Thursday workout
    Workout friday;      // stores Friday workout
    Workout saturday;    // stores Saturday workout
    Workout sunday;      // stores Sunday workout


    // EFFECT: construct a WeeklyWorkout
    public WeeklyWorkout() {
        we = new LinkedList<>();
        makeDays();
    }


    // MODIFIES: this
    // EFFECTS: initialize each day of the week into Exercises, then add them to this WeeklyWorkout
    public void makeDays() {
        monday = new Workout();
        tuesday = new Workout();
        wednesday = new Workout();
        thursday = new Workout();
        friday = new Workout();
        saturday = new Workout();
        sunday = new Workout();

        we.add(monday);
        we.add(tuesday);
        we.add(wednesday);
        we.add(thursday);
        we.add(friday);
        we.add(saturday);
        we.add(sunday);
    }


    // REQUIRES: name is non zero length; sets > 0; reps >0
    // MODIFIES: this
    // EFFECT: select the correct day by matching i to the corresponding day value;
    //         add an exercise with name, sets, and reps to that day
    public void generateNewWorkout(int i, String name, int sets, int reps) {
        if (i == 1) {
            monday.addExercise(name, sets, reps);
        } else if (i == 2) {
            tuesday.addExercise(name, sets, reps);
        } else if (i == 3) {
            wednesday.addExercise(name, sets, reps);
        } else if (i == 4) {
            thursday.addExercise(name, sets, reps);
        } else if (i == 5) {
            friday.addExercise(name, sets, reps);
        } else if (i == 6) {
            saturday.addExercise(name, sets, reps);
        } else if (i == 7) {
            sunday.addExercise(name, sets, reps);
        }
    }


    // MODIFIES: this
    // EFFECTS: select the correct day by matching i to the corresponding day value;
    //          remove the exercise with name s from that day
    public void removeWorkout(int i, int key) {
        if (i == 1) {
            monday.removeExercise(key);
        } else if (i == 2) {
            tuesday.removeExercise(key);
        } else if (i == 3) {
            wednesday.removeExercise(key);
        } else if (i == 4) {
            thursday.removeExercise(key);
        } else if (i == 5) {
            friday.removeExercise(key);
        } else if (i == 6) {
            saturday.removeExercise(key);
        } else if (i == 7) {
            sunday.removeExercise(key);
        }
    }

    // MODIFIES: this
    // EFFECTS: for each exercise in the corresponding pre-made exercise list,
    //          identify the name, set, reps, and pass them to a day
    public void addBeginnerWorkout() {

        for (Exercise e : beginnerUpperBody) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();

            monday.addExercise(name, set, reps);
            thursday.addExercise(name, set, reps);
        }
        for (Exercise e : beginnerLowerBody) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();

            tuesday.addExercise(name, set, reps);
            friday.addExercise(name, set, reps);
        }
        for (Exercise e : beginnerCardio) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();

            saturday.addExercise(name, set, reps);
        }
    }


    // MODIFIES: this
    // EFFECTS: for each exercise in the corresponding pre-made exercise list,
    //          identify the name, set, reps, and pass them to a day
    public void addIntermediateWorkoutPushPull() {

        for (Exercise e : intPush) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            monday.addExercise(name, set, reps);
            thursday.addExercise(name, set, reps);
        }
        for (Exercise e : intPull) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            tuesday.addExercise(name, set, reps);
            friday.addExercise(name, set, reps);
        }
    }


    // MODIFIES: this
    // EFFECTS: for each exercise in the corresponding pre-made exercise list,
    //          identify the name, set, reps, and pass them to a day
    public void addIntermediateWorkoutLegsCardio() {

        for (Exercise e : intLegs) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            wednesday.addExercise(name, set, reps);
            saturday.addExercise(name, set, reps);
        }
        for (Exercise e : intCardio) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            sunday.addExercise(name, set, reps);
        }
    }


    // MODIFIES: this
    // EFFECTS: for each exercise in the corresponding pre-made exercise list,
    //          identify the name, set, reps, and pass them to a day
    public void addAdvancedWorkoutChestBack() {

        for (Exercise e : advChestTricep) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            monday.addExercise(name, set, reps);
            thursday.addExercise(name, set, reps);
        }
        for (Exercise e : advBackBicep) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            tuesday.addExercise(name, set, reps);
            friday.addExercise(name, set, reps);
        }
    }


    // MODIFIES: this
    // EFFECTS: for each exercise in the corresponding pre-made exercise list,
    //          identify the name, set, reps, and pass them to a day
    public void addAdvancedWorkoutLegCardio() {

        for (Exercise e : adcLegAbs) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            wednesday.addExercise(name, set, reps);
            saturday.addExercise(name, set, reps);
        }
        for (Exercise e : advCardio) {
            String name = e.getName();
            int set = e.getSets();
            int reps = e.getReps();
            sunday.addExercise(name, set, reps);

        }
    }


    //     REQUIRES: string is non zero length
    //     EFFECTS: select the correct day by matching i to the corresponding day value;
    //              return false if any exercise has the key in the corresponding day;
    //              true if otherwise
    public boolean lookForExercise(int i, int key) {
        Boolean count = false;
        if (i == 1) {
            count = monday.canFind(key);
        } else if (i == 2) {
            count = tuesday.canFind(key);
        } else if (i == 3) {
            count = wednesday.canFind(key);
        } else if (i == 4) {
            count = thursday.canFind(key);
        } else if (i == 5) {
            count = friday.canFind(key);
        } else if (i == 6) {
            count = saturday.canFind(key);
        } else if (i == 7) {
            count = sunday.canFind(key);
        }
        return !count;
    }


    public Workout getMonday() {
        return monday;
    }

    public Workout getTuesday() {
        return tuesday;
    }

    public Workout getWednesday() {
        return wednesday;
    }

    public Workout getThursday() {
        return thursday;
    }

    public Workout getFriday() {
        return friday;
    }

    public Workout getSaturday() {
        return saturday;
    }

    public Workout getSunday() {
        return sunday;
    }

    public List<Workout> getWeeklyWorkout() {
        return we;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("we", weToJson());
        return json;
    }

    // EFFECTS: returns workouts in this WeeklyWorkout as a JSON array
    private JSONArray weToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout t : we) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }
}

