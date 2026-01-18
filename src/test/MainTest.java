package edu.course.eventplanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void testMainRunsWithoutError() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}