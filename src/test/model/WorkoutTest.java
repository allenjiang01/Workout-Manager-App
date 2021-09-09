package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    Workout exerciseList;

    @BeforeEach
    public void setUp() {
        exerciseList = new Workout();
    }

    @Test
    public void testAddExerciseDifferent() {
        exerciseList.addExercise("test 1", 3, 10);
        exerciseList.addExercise("test 2", 1, 1);
        Assertions.assertEquals(2,exerciseList.getExercises().size());
    }


    @Test
    public void testRemoveExerciseOne() {
        Assertions.assertEquals(0,exerciseList.getExercises().size());
        exerciseList.addExercise("test 1", 3, 10);
        Assertions.assertEquals(1,exerciseList.getExercises().size());
        exerciseList.removeExercise(1);
        Assertions.assertEquals(0,exerciseList.getExercises().size());
    }

    @Test
    public void testRemoveExerciseTwoDifferent() {
        Assertions.assertEquals(0,exerciseList.getExercises().size());
        exerciseList.addExercise("test 1", 3, 10);
        exerciseList.addExercise("test 2", 3, 10);
        Assertions.assertEquals(2,exerciseList.getExercises().size());
        exerciseList.removeExercise(1);
        Assertions.assertEquals(1,exerciseList.getExercises().size());
    }


    @Test
    public void testRemoveExerciseNonFound() {
        Assertions.assertEquals(0,exerciseList.getExercises().size());
        exerciseList.addExercise("test 1", 3, 10);
        exerciseList.addExercise("test 1", 3, 10);
        Assertions.assertEquals(2,exerciseList.getExercises().size());
        exerciseList.removeExercise(3);
        Assertions.assertEquals(2,exerciseList.getExercises().size());
    }

    @Test
    public void testCanFindTrue() {
        Exercise e1 = new Exercise("test 1", 3, 10);
        exerciseList.addExercise("test 1", 3, 10);
        Assertions.assertEquals(1, exerciseList.exercises.size());
        Assertions.assertTrue(exerciseList.canFind(1));
    }

    @Test
    public void testCanFindFalse() {
       // Exercise e1 = new Exercise("test 1", 3, 10);
        exerciseList.addExercise("test 2", 3, 10);
        Assertions.assertEquals(1, exerciseList.exercises.size());
        Assertions.assertFalse(exerciseList.canFind(2));
    }

}