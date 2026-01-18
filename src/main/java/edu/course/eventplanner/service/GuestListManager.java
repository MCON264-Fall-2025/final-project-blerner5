package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuestListManager {
    private final LinkedList<Guest> guests = new LinkedList<>();
    private final Map<String, Guest> guestsByName = new HashMap<>();

    public GuestListManager() {
    }

    public void addGuest(Guest guest) {
        if (guest != null) {
            guests.add(guest);
            guestsByName.put(guest.getName(), guest);
        }
    }

    public boolean removeGuest(String guestName) {
        Guest removed = guestsByName.remove(guestName);
        if (removed == null) {
            return false;
        }
        guests.removeIf(g -> g.getName().equals(guestName));
        return true;
    }

    public Guest findGuest(String guestName) {
        return guestsByName.get(guestName);
    }

    public int getGuestCount() {
        return guests.size();
    }

    public List<Guest> getAllGuests() {
        return new LinkedList<>(guests);
    }
}