package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeatingPlannerTest {


    @Test
    public void testSeatingPlanner() {
        Venue venue = new Venue("Palace", "10,000", "500", "50", "10");

        assertEquals("Palace", venue.getName());
        assertEquals( "10,000", venue.getCost());
        assertEquals("500", venue.getTables());
        assertEquals("50", venue.getTables());
        assertEquals("10",  venue.getSeatsPerTable());
    }
}

    @Test
    public void generateSeatingTest() {
        Map<Integer, List<Guest>> generateSeating = new Map<Integer, List<Guest>>() {
        List<Guest> guests = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            guests.add(new Guest("Guest" + i, "General"));
        }

        List<Table> tables = planner.generateSeating(guests, venue);

        assertEquals(3, tables.size());
        assertEquals(10, tables.get(0).getGuests().size());
        assertEquals(10, tables.get(1).getGuests().size());
        assertEquals(5, tables.get(2).getGuests().size());