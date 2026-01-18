package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;

import java.util.*;

public class SeatingPlanner {
    private final Venue venue;

    public SeatingPlanner(Venue venue) {
        this.venue = venue;
    }

    public Map<Integer, List<Guest>> generateSeating(List<Guest> guests) {
        Map<Integer, List<Guest>> seatingMap = new LinkedHashMap<>();
        if (guests == null || guests.isEmpty()) {
            return seatingMap;
        }
        int seatsPerTable = venue.getSeatsPerTable();
        int maxTables = venue.getTables();
        if (seatsPerTable <= 0 || maxTables <= 0) {
            return seatingMap;
        }
        Map<String, Queue<Guest>> groups = new HashMap<>();
        for (Guest g : guests) {
            groups.computeIfAbsent(g.getGroupTag(), k -> new LinkedList<>()).add(g);
        }
        TreeMap<String, Queue<Guest>> orderedGroups = new TreeMap<>(groups);
        int tableNumber = 1;
        List<Guest> currentTable = new ArrayList<>();
        for (Queue<Guest> queue : orderedGroups.values()) {
            while (!queue.isEmpty()) {
                if (tableNumber > maxTables) {
                    return seatingMap;
                }
                currentTable.add(queue.poll());
                if (currentTable.size() == seatsPerTable) {
                    seatingMap.put(tableNumber, currentTable);
                    tableNumber++;
                    currentTable = new ArrayList<>();
                }
            }
        }
        if (!currentTable.isEmpty() && tableNumber <= maxTables) {
            seatingMap.put(tableNumber, currentTable);
        }
        return seatingMap;
    }
}