package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;
import java.util.*;

public class VenueSelector {
    private final List<Venue> venues;
    public VenueSelector(List<Venue> venues) {
        this.venues = venues;
    }
    public Venue selectVenue(double budget, int guestCount) {
        for (int i = 0; i < venues.size(); i++) {
            Venue v = venues.get(i);
            if (v.getCost() <= budget && v.getCapacity() >= guestCount) {
                return v;
            }
        } return null;
    }
}
