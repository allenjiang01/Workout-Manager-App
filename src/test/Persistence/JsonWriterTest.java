package Persistence;

import model.WeeklyWorkout;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            WeeklyWorkout we = new WeeklyWorkout();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            WeeklyWorkout we = new WeeklyWorkout();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(we);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            we = reader.read();
            assertEquals(7, we.getWeeklyWorkout().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            WeeklyWorkout we = new WeeklyWorkout();
            we.getMonday().addExercise("Leg Press", 5, 10);
            we.getMonday().addExercise("Push Up", 6, 12);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(we);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            we = reader.read();
            assertEquals(7, we.getWeeklyWorkout().size());
            assertEquals(2, we.getMonday().getExercises().size());
            assertEquals("Push Up", we.getMonday().getExercises().get(2).getName());
            assertEquals(6, we.getMonday().getExercises().get(2).getSets());
            assertEquals(12, we.getMonday().getExercises().get(2).getReps());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

    }
}
