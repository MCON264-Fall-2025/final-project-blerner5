package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import java.util.*;

public class GuestListManager {
    private final LinkedList<Guest> guests = new LinkedList<>();
    private final Map<String, Guest> guestByName = new HashMap<>();

    public void addGuest(Guest guest) {
        if (guest == null || guest.getName() == null) {
            return;
        }

        guests.add(guest);
        guestByName.put(guest.getName(), guest);
    }

    public boolean removeGuest(String guestName) {
        Guest guest = guestByName.remove(guestName);
        if (guest == null) {
            return false; //
        }

        guests.remove(guest);
        return true;
    }

    public Guest findGuest(String guestName) {
        Guest guest = guestByName.get(guestName);
        if (guest == null) {
            return null;
        }

        return guest;
    }

    public int getGuestCount() {
        return guests.size();
    }
    public List<Guest> getAllGuests() {
        return guests;
    }
}
