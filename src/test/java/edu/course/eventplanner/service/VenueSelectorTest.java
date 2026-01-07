package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class VenueSelectorTest {
    @Test
    public void selectVenue() {
        Venue venue = new Venue("The Rockleigh", 50000, 500, 50, 10 );
        Venue venue2 = new Venue("Marina Del Ray", 30000, 400, 40, 10 );

        List<Venue> venues = List.of(venue, venue2);
        VenueSelector venueSelector = new VenueSelector(venues);

        Venue budgeted = venueSelector.selectVenue(60000, 300);

        assertEquals(venue,budgeted);
    }
}
