package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VenueSelectorTest {
    @DisplayName("Returns null when no venue fits the budget")
    @Test
    void testNoVenueFitsBudget() {
        List<Venue> venues = List.of(new Venue("A", 5000, 100, 10, 10));
        VenueSelector selector = new VenueSelector(venues);
        Venue result = selector.selectVenue(1000, 50);
        assertNull(result);
    }

    @DisplayName("Returns null when no venue fits the guest count")
    @Test
    void testNoVenueFitsGuestCount() {
        List<Venue> venues = List.of(new Venue("A", 1000, 50, 5, 10));
        VenueSelector selector = new VenueSelector(venues);
        Venue result = selector.selectVenue(2000, 200);
        assertNull(result);
    }

    @DisplayName("Selects the cheapest venue when multiple venues fit")
    @Test
    void testSelectCheapestVenue() {
        List<Venue> venues = List.of(new Venue("A", 3000, 200, 20, 10),
                new Venue("B", 2500, 200, 20, 10),
                new Venue("C", 4000, 200, 20, 10));
        VenueSelector selector = new VenueSelector(venues);
        Venue result = selector.selectVenue(5000, 150);
        assertNotNull(result);
        assertEquals("B", result.getName());
    }
}