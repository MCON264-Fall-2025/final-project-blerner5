package edu.course.eventplanner.util;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorsTest {
    @Test
    void testGenerateGuestsReturnsCorrectCount() {
        List<Guest> guests = Generators.GenerateGuests(10);
        assertEquals(10, guests.size()); assertNotNull(guests.get(0));
    }
    @Test void testGenerateGuestsZeroCount() {
        List<Guest> guests = Generators.GenerateGuests(0);
        assertTrue(guests.isEmpty());
    }
    @Test void testGenerateVenuesReturnsCorrectCount() {
        List<Venue> venues = Generators.generateVenues();
        assertEquals(3, venues.size());
        assertNotNull(venues.get(0));
    }
}