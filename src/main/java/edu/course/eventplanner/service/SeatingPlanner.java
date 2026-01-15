package edu.course.eventplanner.service;

import edu.course.eventplanner.model.*;
import java.util.*;

public class SeatingPlanner {
    private final Venue venue;
    public SeatingPlanner(Venue venue) {
        this.venue = venue;
    }
    public Map<Integer, List<Guest>> generateSeating(List<Guest> guests) {
        Map<Integer, List<Guest>> seatingMap = new HashMap<>();
        int SPT = venue.getSeatsPerTable();
        int tables = 1;

        List<Guest> currentTable = new ArrayList<>();

        for (int i = 0; i < guests.size(); i++) {
            currentTable.add(guests.get(i));

            if((currentTable.size() == SPT)) {
                seatingMap.put(tables, currentTable);
                tables++;
                currentTable = new ArrayList<>();
            }
        }
        if (!currentTable.isEmpty()) {
            seatingMap.put(tables, currentTable);
        }
        return seatingMap;
    }
}