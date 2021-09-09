package Persistence;

import model.Exercise;
import model.WeeklyWorkout;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WeeklyWorkout ww = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomMonday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getMonday().getExercises().size());
            assertEquals("Bench Press", ww.getMonday().getExercises().get(1).getName());
            assertEquals(6, ww.getMonday().getExercises().get(1).getReps());
            assertEquals(4, ww.getMonday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getMonday().getExercises().get(2).getName());
            assertEquals(10, ww.getMonday().getExercises().get(2).getReps());
            assertEquals(4, ww.getMonday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomTuesday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getTuesday().getExercises().size());
            assertEquals("Bench Press", ww.getTuesday().getExercises().get(1).getName());
            assertEquals(6, ww.getTuesday().getExercises().get(1).getReps());
            assertEquals(4, ww.getTuesday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getTuesday().getExercises().get(2).getName());
            assertEquals(10, ww.getTuesday().getExercises().get(2).getReps());
            assertEquals(4, ww.getTuesday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomWednesday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getWednesday().getExercises().size());
            assertEquals("Bench Press", ww.getWednesday().getExercises().get(1).getName());
            assertEquals(6, ww.getWednesday().getExercises().get(1).getReps());
            assertEquals(4, ww.getWednesday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getWednesday().getExercises().get(2).getName());
            assertEquals(10, ww.getWednesday().getExercises().get(2).getReps());
            assertEquals(4, ww.getWednesday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomThursday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getThursday().getExercises().size());
            assertEquals("Bench Press", ww.getThursday().getExercises().get(1).getName());
            assertEquals(6, ww.getThursday().getExercises().get(1).getReps());
            assertEquals(4, ww.getThursday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getThursday().getExercises().get(2).getName());
            assertEquals(10, ww.getThursday().getExercises().get(2).getReps());
            assertEquals(4, ww.getThursday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomFriday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getFriday().getExercises().size());
            assertEquals("Bench Press", ww.getFriday().getExercises().get(1).getName());
            assertEquals(6, ww.getFriday().getExercises().get(1).getReps());
            assertEquals(4, ww.getFriday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getFriday().getExercises().get(2).getName());
            assertEquals(10, ww.getFriday().getExercises().get(2).getReps());
            assertEquals(4, ww.getFriday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomSaturday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getSaturday().getExercises().size());
            assertEquals("Bench Press", ww.getSaturday().getExercises().get(1).getName());
            assertEquals(1, ww.getSaturday().getExercises().get(1).getReps());
            assertEquals(1, ww.getSaturday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getSaturday().getExercises().get(2).getName());
            assertEquals(1, ww.getSaturday().getExercises().get(2).getReps());
            assertEquals(1, ww.getSaturday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomSunday() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getSunday().getExercises().size());
            assertEquals("Bench Press", ww.getSunday().getExercises().get(1).getName());
            assertEquals(6, ww.getSunday().getExercises().get(1).getReps());
            assertEquals(4, ww.getSunday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getSunday().getExercises().get(2).getName());
            assertEquals(10, ww.getSunday().getExercises().get(2).getReps());
            assertEquals(4, ww.getSunday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoomMulti() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WeeklyWorkout ww = reader.read();
            assertEquals(7, ww.getWeeklyWorkout().size());
            assertEquals(2, ww.getSaturday().getExercises().size());
            assertEquals(2, ww.getSunday().getExercises().size());

            assertEquals("Bench Press", ww.getSaturday().getExercises().get(1).getName());
            assertEquals(1, ww.getSaturday().getExercises().get(1).getReps());
            assertEquals(1, ww.getSaturday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getSaturday().getExercises().get(2).getName());
            assertEquals(1, ww.getSaturday().getExercises().get(2).getReps());
            assertEquals(1, ww.getSaturday().getExercises().get(2).getSets());

            assertEquals("Bench Press", ww.getSunday().getExercises().get(1).getName());
            assertEquals(6, ww.getSunday().getExercises().get(1).getReps());
            assertEquals(4, ww.getSunday().getExercises().get(1).getSets());
            assertEquals("Push Up", ww.getSunday().getExercises().get(2).getName());
            assertEquals(10, ww.getSunday().getExercises().get(2).getReps());
            assertEquals(4, ww.getSunday().getExercises().get(2).getSets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

