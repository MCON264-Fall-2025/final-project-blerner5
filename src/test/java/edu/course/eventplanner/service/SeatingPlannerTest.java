package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeatingPlannerTest {


    @Test
    public void testSeatingPlanner() {
        Venue venue = new Venue("Palace", 10000,500, 50, 10);

        assertEquals("Palace", venue.getName());
        assertEquals( 10000.00, venue.getCost());
        assertEquals(500, venue.getCapacity());
        assertEquals(50, venue.getTables());
        assertEquals(10,  venue.getSeatsPerTable());
    }


    @Test
    public void generateSeatingTest() {
        Venue venue = new Venue("Palace", 10000,500, 50, 10);
        SeatingPlanner planner = new SeatingPlanner(venue);

        List <Guest> guests = new ArrayList<>();
        for(int i =0; i<325; i++) {
            guests.add(new Guest("guest " +i , " description "));
        }

        Map<Integer, List<Guest>> seatingMap = planner.generateSeating(guests);

        assertNotNull(seatingMap);
        assertEquals(33, seatingMap.size());

        assertEquals(10, seatingMap.get(1).size());
        assertEquals(10, seatingMap.get(2).size());
        assertEquals(10, seatingMap.get(3).size());

        assertEquals(5, seatingMap.get(33).size());

        assertEquals("guest 0 description", seatingMap.get(1).get(0).getName());
        assertEquals("guest 10 description", seatingMap.get(2).get(0).getName());
        assertEquals("guest 20 description", seatingMap.get(3).get(0).getName()); }


}
