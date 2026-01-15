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
        VenueSelector selector = new VenueSelector();
        List<Venue> venues = List.of(new Venue("A", 5000, 100, 10, 10));
        Venue result = selector.selectVenue(venues, 50, 1000);
        assertNull(result);
    }

    @DisplayName("Returns null when no venue fits the guest count")
    @Test
    void testNoVenueFitsGuestCount() {
        VenueSelector selector = new VenueSelector();
        List<Venue> venues = List.of(new Venue("A", 1000, 50, 5, 10));
        Venue result = selector.selectVenue(venues, 200, 2000);
        assertNull(result);
    }

    @DisplayName("Selects the cheapest venue when multiple venues fit")
    @Test
    void testSelectCheapestVenue() {
        VenueSelector selector = new VenueSelector();
        List<Venue> venues = List.of(new Venue("A", 3000, 200, 20, 10),
                new Venue("B", 2500, 200, 20, 10),
                new Venue("C", 4000, 200, 20, 10));
        Venue result = selector.selectVenue(venues, 150, 5000);
        assertNotNull(result);
        assertEquals("B", result.getName());
    }
}