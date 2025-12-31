package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;
import edu.course.eventplanner.model.Guest;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeatingPlannerTest {

    @Test
    public void testSeatingPlanner() {
        Venue venue = new Venue("Palace", "10,000", "500", "50", "10");

        AssertEquals("Palace", "10,000", "500", "50", "10");

    }

}
