package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GuestListManagerTest {
    @Test
    public void testAddGuest() {
        GuestListManager list = new GuestListManager();
        Guest guest = new Guest("Leah", "Family");

        list.addGuest(guest);

        assertEquals(1, list.getGuestCount());
        assertEquals(guest, list.findGuest("Leah"));
    }

    @Test
    public void testRemoveGuest() {
        GuestListManager list = new GuestListManager();
        Guest guest = new Guest("Leah", "Family");

        list.addGuest(guest);

        boolean removed = list.removeGuest("Leah");
        assertTrue(removed);
        assertEquals(0, list.getGuestCount());
        assertEquals(null, list.findGuest("Leah"));

    }

    @Test
    public void testFindGuest() {
        GuestListManager list = new GuestListManager();
        Guest guest = new Guest("Leah", "Family");
        list.addGuest(guest);
        Guest search = list.findGuest("Leah");

        assertNotNull(search);
        assertEquals("Leah", search.getName());
    }

    @Test
    public void testGetGuestCount() {
        GuestListManager list = new GuestListManager();

        assertEquals(0, list.getGuestCount());

        list.addGuest(new Guest("Leah", "Family"));

        assertEquals(1, list.getGuestCount());
    }

    @Test
    public void getAllGuests() {
        GuestListManager list = new GuestListManager();
        list.addGuest(new Guest("Leah", "Family"));
        list.addGuest(new Guest("libby", "Family"));
        list.addGuest(new Guest("Itty", "Family"));

        assertEquals(3, list.getAllGuests().size());
        assertEquals("Leah", list.getAllGuests().get(0).getName());
        assertEquals("libby", list.getAllGuests().get(1).getName());
        assertEquals("Itty", list.getAllGuests().get(2).getName());
    }
}
