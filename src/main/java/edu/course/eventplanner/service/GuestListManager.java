package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestListManager {
    private final List<Guest> guests = new ArrayList<>();

    public void addGuest(Guest guest) {
        if (guest != null) {
            guests.add(guest);
        }
    }

    public boolean removeGuest(String guestName) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getName().equals(guestName)) {
                guests.remove(i);
                return true;
            }
        }
        return false;
    }

    public Guest findGuest(String guestName) {
        for (Guest g : guests) {
            if (g.getName().equals(guestName)) {
                return g;
            }
        }
        return null;
    }

    public int getGuestCount() {
        return guests.size();
    }

    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests);
    }
}