package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeeklyWorkoutTest implements Preset {
    WeeklyWorkout we;

    @BeforeEach
    public void setUp() {
        we = new WeeklyWorkout();
    }

    @Test
    public void testMakeDays() {
        Assertions.assertEquals(7, we.getWeeklyWorkout().size());
    }

    @Test
    public void testGenerateNewWorkoutMonday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(1, "test 1", 3, 1);
        Assertions.assertEquals(1, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutTuesday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(2, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(1, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutWednesday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(3, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(1, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutThursday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(4, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(1, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutFriday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(5, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(1, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutSaturday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(6, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(1, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutSunday() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(7, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(1, we.getSunday().getExercises().size());
    }


    @Test
    public void testGenerateNewWorkoutNonValid() {
        we.makeDays();
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
        we.generateNewWorkout(0, "test 1", 3, 1);
        we.generateNewWorkout(0, "test 1", 3, 1);
        we.generateNewWorkout(0, "test 1", 3, 1);
        we.generateNewWorkout(0, "test 1", 3, 1);
        we.generateNewWorkout(0, "test 1", 3, 1);
        we.generateNewWorkout(0, "test 1", 3, 1);
        we.generateNewWorkout(0, "test 1", 3, 1);
        Assertions.assertEquals(0, we.getMonday().getExercises().size());
        Assertions.assertEquals(0, we.getTuesday().getExercises().size());
        Assertions.assertEquals(0, we.getWednesday().getExercises().size());
        Assertions.assertEquals(0, we.getThursday().getExercises().size());
        Assertions.assertEquals(0, we.getFriday().getExercises().size());
        Assertions.assertEquals(0, we.getSaturday().getExercises().size());
        Assertions.assertEquals(0, we.getSunday().getExercises().size());
    }

    @Test
    public void testGenerateNewWorkoutAddTwo() {
        we.makeDays();
        Assertions.assertEquals(0, we.monday.getExercises().size());
        we.generateNewWorkout(1, "test 1", 3, 1);
        Assertions.assertEquals(1, we.monday.getExercises().size());
        we.generateNewWorkout(1, "test 2", 3, 1);
        Assertions.assertEquals(2, we.monday.getExercises().size());
    }

    @Test
    public void testRemoveWorkout() {
        we.makeDays();
        Assertions.assertEquals(0, we.monday.getExercises().size());
        Assertions.assertEquals(0, we.tuesday.getExercises().size());
        we.generateNewWorkout(1, "test 1", 3, 1);
        we.generateNewWorkout(2, "test 1", 3, 1);
        we.generateNewWorkout(2, "test 2", 3, 1);
        Assertions.assertEquals(1, we.monday.getExercises().size());
        Assertions.assertEquals(2, we.tuesday.getExercises().size());
        we.removeWorkout(1, 1);
        we.removeWorkout(2, 1);
        Assertions.assertEquals(0, we.monday.getExercises().size());
        Assertions.assertEquals(1, we.tuesday.getExercises().size());
    }

    @Test
    public void testRemoveWorkoutWedThursFri() {
        we.makeDays();
        Assertions.assertEquals(0, we.wednesday.getExercises().size());
        Assertions.assertEquals(0, we.thursday.getExercises().size());
        Assertions.assertEquals(0, we.friday.getExercises().size());
        we.generateNewWorkout(3, "test 1", 3, 1);
        we.generateNewWorkout(4, "test 1", 3, 1);
        we.generateNewWorkout(5, "test 2", 3, 1);
        we.generateNewWorkout(5, "test 2", 3, 1);
        we.removeWorkout(3, 1);
        we.removeWorkout(4, 1);
        we.removeWorkout(5, 1);
        Assertions.assertEquals(0, we.wednesday.getExercises().size());
        Assertions.assertEquals(0, we.thursday.getExercises().size());
        Assertions.assertEquals(1, we.friday.getExercises().size());
    }

    @Test
    public void testRemoveWorkoutSatSun() {
        we.makeDays();
        Assertions.assertEquals(0, we.saturday.getExercises().size());
        Assertions.assertEquals(0, we.sunday.getExercises().size());
        we.generateNewWorkout(6, "test 1", 3, 1);
        we.generateNewWorkout(6, "test 1", 3, 1);
        we.generateNewWorkout(7, "test 2", 3, 1);
        we.generateNewWorkout(7, "test 2", 3, 1);
        we.removeWorkout(6, 1);
        we.removeWorkout(6, 1);
        we.removeWorkout(7, 1);
        Assertions.assertEquals(0, we.saturday.getExercises().size());
        Assertions.assertEquals(1, we.sunday.getExercises().size());
    }

    @Test
    public void testRemoveWorkoutNoExercise() {
        we.makeDays();
        Assertions.assertEquals(0, we.sunday.getExercises().size());
        we.generateNewWorkout(7, "test 2", 3, 1);
        Assertions.assertEquals(0, we.monday.getExercises().size());
        Assertions.assertEquals(1, we.sunday.getExercises().size());
        we.removeWorkout(1, 1);
        Assertions.assertEquals(0, we.monday.getExercises().size());
        Assertions.assertEquals(1, we.sunday.getExercises().size());
    }

    @Test
    public void testRemoveWorkoutNonValid() {
        we.makeDays();
        Assertions.assertEquals(0, we.sunday.getExercises().size());
        we.generateNewWorkout(7, "test 2", 3, 1);
        Assertions.assertEquals(1, we.sunday.getExercises().size());
        we.removeWorkout(8, 1);
        Assertions.assertEquals(0, we.monday.getExercises().size());
        Assertions.assertEquals(0, we.tuesday.getExercises().size());
        Assertions.assertEquals(0, we.wednesday.getExercises().size());
        Assertions.assertEquals(0, we.thursday.getExercises().size());
        Assertions.assertEquals(0, we.friday.getExercises().size());
        Assertions.assertEquals(0, we.saturday.getExercises().size());
        Assertions.assertEquals(1, we.sunday.getExercises().size());
    }

    @Test
    public void testAddBeginnerWorkout() {
        we.makeDays();
        Assertions.assertEquals(5, beginnerUpperBody.size());
        Assertions.assertEquals(0, we.monday.getExercises().size());
        we.addBeginnerWorkout();
        Assertions.assertEquals(5, we.monday.getExercises().size());
    }

    @Test
    public void testAddIntermediateWorkoutPushPull() {
        we.makeDays();
        Assertions.assertEquals(7, intPush.size());
        Assertions.assertEquals(0, we.monday.getExercises().size());
        we.addIntermediateWorkoutPushPull();
        Assertions.assertEquals(7, we.monday.getExercises().size());
    }

    @Test
    public void testAddIntermediateWorkoutLegsCardio() {
        we.makeDays();
        Assertions.assertEquals(5, intLegs.size());
        Assertions.assertEquals(0, we.wednesday.getExercises().size());
        we.addIntermediateWorkoutLegsCardio();
        Assertions.assertEquals(5, we.wednesday.getExercises().size());
    }

    @Test
    public void testAddAdvancedWorkoutChestBack() {
        we.makeDays();
        Assertions.assertEquals(10, advChestTricep.size());
        Assertions.assertEquals(0, we.monday.getExercises().size());
        we.addAdvancedWorkoutChestBack();
        Assertions.assertEquals(10, we.monday.getExercises().size());
    }

    @Test
    public void testAddAdvancedWorkoutLegCardio() {
        we.makeDays();
        Assertions.assertEquals(8, adcLegAbs.size());
        Assertions.assertEquals(0, we.wednesday.getExercises().size());
        we.addAdvancedWorkoutLegCardio();
        Assertions.assertEquals(8, we.wednesday.getExercises().size());
    }

    @Test
    public void testLookForExerciseFalse() {
        we.makeDays();
        Assertions.assertTrue(we.lookForExercise(1,1));
        Assertions.assertTrue(we.lookForExercise(2,2));
        Assertions.assertTrue(we.lookForExercise(3,3));
        Assertions.assertTrue(we.lookForExercise(4,4));
        Assertions.assertTrue(we.lookForExercise(5,5));
        Assertions.assertTrue(we.lookForExercise(6,6));
        Assertions.assertTrue(we.lookForExercise(7,7));
        we.monday.addExercise("test 1",3,1);
        we.tuesday.addExercise("test 1",3,1);
        we.wednesday.addExercise("test 1",3,1);
        we.thursday.addExercise("test 1",3,1);
        we.friday.addExercise("test 1",3,1);
        we.saturday.addExercise("test 1",3,1);
        we.sunday.addExercise("test 1",3,1);
        Assertions.assertFalse(we.lookForExercise(1,1));
        Assertions.assertFalse(we.lookForExercise(2,1));
        Assertions.assertFalse(we.lookForExercise(3,1));
        Assertions.assertFalse(we.lookForExercise(3,1));
        Assertions.assertFalse(we.lookForExercise(4,1));
        Assertions.assertFalse(we.lookForExercise(5,1));
        Assertions.assertFalse(we.lookForExercise(6,1));
        Assertions.assertFalse(we.lookForExercise(7,1));
    }

    @Test
    public void testLookForExerciseTrue() {
        we.makeDays();
        Assertions.assertTrue(we.lookForExercise(1,1));
        Assertions.assertTrue(we.lookForExercise(2,2));
        Assertions.assertTrue(we.lookForExercise(3,3));
        Assertions.assertTrue(we.lookForExercise(4,4));
        Assertions.assertTrue(we.lookForExercise(5,5));
        Assertions.assertTrue(we.lookForExercise(6,6));
        Assertions.assertTrue(we.lookForExercise(7,7));
        we.monday.addExercise("test 2",3,1);
        we.tuesday.addExercise("test 2",3,1);
        we.wednesday.addExercise("test 2",3,1);
        we.thursday.addExercise("test 2",3,1);
        we.friday.addExercise("test 2",3,1);
        we.saturday.addExercise("test 2",3,1);
        we.sunday.addExercise("test 2",3,1);
        Assertions.assertTrue(we.lookForExercise(1,2));
        Assertions.assertTrue(we.lookForExercise(2,2));
        Assertions.assertTrue(we.lookForExercise(3,2));
        Assertions.assertTrue(we.lookForExercise(3,2));
        Assertions.assertTrue(we.lookForExercise(4,2));
        Assertions.assertTrue(we.lookForExercise(5,2));
        Assertions.assertTrue(we.lookForExercise(6,2));
        Assertions.assertTrue(we.lookForExercise(7,2));
    }

    @Test
    public void testLookForExerciseNonValid() {
        we.makeDays();
        Assertions.assertTrue(we.lookForExercise(7,1));
        we.monday.addExercise("test 1",3,1);
        we.sunday.addExercise("test 3",3,1);
        Assertions.assertFalse(we.lookForExercise(7,1));
        Assertions.assertTrue(we.lookForExercise(8,1));
        Assertions.assertTrue(we.lookForExercise(0,1));
        Assertions.assertTrue(we.lookForExercise(3,1));
    }
}
