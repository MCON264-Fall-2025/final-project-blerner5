package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;

import java.util.List;

public class VenueSelector {
    private final List<Venue> venues;

    public VenueSelector(List<Venue> venues) {
        this.venues = venues;
    }

    public Venue selectVenue(double budget, int guestCount) {
        Venue best = null;
        for (int i = 0; i < venues.size(); i++) {
            Venue v = venues.get(i);
            if (v.getCost() <= budget && v.getCapacity() >= guestCount) {
                if (best == null) {
                    best = v;
                } else if (v.getCost() < best.getCost()) {
                    best = v;
                } else if (v.getCost() == best.getCost() && v.getCapacity() < best.getCapacity()) {
                    best = v;
                }
            }
        }
        return best;
    }
}