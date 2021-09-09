package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExerciseTest {
    Exercise exercise;

    @BeforeEach
    public void setUp() {
        exercise = new Exercise("test", 3, 12);
    }

    @Test
    public void testConstructor() {
        Assertions.assertEquals("test", exercise.getName());
        Assertions.assertEquals(3, exercise.getSets());
        Assertions.assertEquals(12, exercise.getReps());

    }
}
