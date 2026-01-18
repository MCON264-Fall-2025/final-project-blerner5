package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;

import java.util.List;

public class VenueSelector {
    public VenueSelector() {
    }

    public Venue selectVenue(List<Venue> venues, int guestCount, double budget) {
        Venue best = null;
        for (int i = 0; i < venues.size(); i++) {
            Venue v = venues.get(i);
            if (v.getCapacity() >= guestCount && v.getCost() <= budget) {
                if (best == null || v.getCost() < best.getCost()) {
                    best = v;
                }
            }
        }
        return best;
    }
}