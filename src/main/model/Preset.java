package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// Stores all pre-made exercises and workouts
public interface Preset {
    Exercise benchPress = new Exercise("Bench Press", 4, 6);
    Exercise pushUp = new Exercise("Push Up", 3, 20);
    Exercise latPulldown = new Exercise("Lat Pulldown", 3, 12);
    Exercise shoulderPress = new Exercise("Shoulder Press", 4, 6);
    Exercise dumbbellRow = new Exercise("Dumbbell Row", 3, 12);
    Exercise barbellDeadlift = new Exercise("Barbell Deadlift", 4, 6);
    Exercise barbellSquat = new Exercise("Barbell Squat", 4, 12);
    Exercise legExtension = new Exercise("Leg Extension", 3, 12);
    Exercise legCurl = new Exercise("Leg Curl", 3, 12);
    Exercise jog = new Exercise("20 Min Jog", 1, 1);
    Exercise sprint100 = new Exercise("100m Sprint", 3, 1);
    Exercise dip = new Exercise("Dip", 3, 12);
    Exercise cableFly = new Exercise("Cable Fly", 3, 12);
    Exercise sideRaise = new Exercise("Side Raises", 3, 12);
    Exercise tricepPulldown = new Exercise("Tricep Pulldown", 3, 12);
    Exercise tricepExtension = new Exercise("Tricep Extension", 3, 12);
    Exercise pullUp = new Exercise("Pull Up", 4, 12);
    Exercise barbellRow = new Exercise("Barbell Row", 3, 12);
    Exercise bicepCurl = new Exercise("Bicep Curl", 3, 12);
    Exercise facePull = new Exercise("Face Pull", 3, 12);
    Exercise sprint400 = new Exercise("400m Sprint", 3, 1);
    Exercise weightedLunge = new Exercise("Weighted Lunges", 3, 12);
    Exercise romanianDeadlift = new Exercise("Romanian Deadlift", 3, 12);
    Exercise concentrationCurl = new Exercise("Concentration Curl", 3, 12);
    Exercise inclineBenchPress = new Exercise("Incline Bench Press", 3, 6);
    Exercise skullCrusher = new Exercise("Skull Crusher", 3, 12);
    Exercise hammerCurl = new Exercise("Hammer Curl", 3, 12);
    Exercise pistolSquat = new Exercise("Pistol Squat", 3, 10);
    Exercise crunch = new Exercise("Crunches", 3, 20);
    Exercise hangingLegRaise = new Exercise("Hanging Leg Raises", 3, 20);
    Exercise shuttleRun = new Exercise("Shuttle Run", 3, 10);
    Exercise burpeeBroadjump = new Exercise("Burpee Broadjump", 3, 20);


    // Beginner workout
    List<Exercise> beginnerUpperBody =
            Collections.unmodifiableList(Arrays.asList(benchPress, pushUp, latPulldown, dumbbellRow,
                    shoulderPress));

    List<Exercise> beginnerLowerBody =
            Collections.unmodifiableList(Arrays.asList(barbellSquat, barbellDeadlift, legExtension, legCurl));

    List<Exercise> beginnerCardio =
            Collections.unmodifiableList(Arrays.asList(jog, sprint100));


    // Intermediate workout
    List<Exercise> intPush =
            Collections.unmodifiableList(Arrays.asList(benchPress, dip, cableFly, shoulderPress, sideRaise,
                    tricepPulldown, tricepExtension));

    List<Exercise> intPull =
            Collections.unmodifiableList(Arrays.asList(barbellDeadlift, pullUp, barbellRow, facePull, bicepCurl,
                    concentrationCurl));

    List<Exercise> intLegs =
            Collections.unmodifiableList(Arrays.asList(barbellSquat, romanianDeadlift, weightedLunge, legExtension,
                    legCurl));

    List<Exercise> intCardio =
            Collections.unmodifiableList(Arrays.asList(jog, sprint400));


    // Advanced workout
    List<Exercise> advChestTricep =
            Collections.unmodifiableList(Arrays.asList(benchPress, inclineBenchPress, dip, cableFly, dip,
                    shoulderPress, sideRaise, tricepPulldown, tricepExtension, skullCrusher));

    List<Exercise> advBackBicep =
            Collections.unmodifiableList(Arrays.asList(barbellDeadlift, pullUp, barbellRow, dumbbellRow, facePull,
                    bicepCurl, hammerCurl, concentrationCurl));

    List<Exercise> adcLegAbs =
            Collections.unmodifiableList(Arrays.asList(barbellSquat, pistolSquat, romanianDeadlift, weightedLunge,
                    legExtension, legCurl, crunch, hangingLegRaise));

    List<Exercise> advCardio =
            Collections.unmodifiableList(Arrays.asList(jog, sprint400, shuttleRun, burpeeBroadjump));
}