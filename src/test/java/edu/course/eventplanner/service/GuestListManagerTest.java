package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GuestListManagerTest {
    @DisplayName("Adding a guest increases count and stores correct guest")
    @Test
    public void testAddGuest() {
        GuestListManager list = new GuestListManager();
        Guest guest = new Guest("Leah", "Family");
        list.addGuest(guest);
        assertEquals(1, list.getGuestCount());
        assertEquals(guest, list.findGuest("Leah"));
    }

    @DisplayName("Removing an existing guest returns true and updates count")
    @Test
    public void testRemoveGuest() {
        GuestListManager list = new GuestListManager();
        Guest guest = new Guest("Leah", "Family");
        list.addGuest(guest);
        boolean removed = list.removeGuest("Leah");
        assertTrue(removed);
        assertEquals(0, list.getGuestCount());
        assertNull(list.findGuest("Leah"));
    }

    @DisplayName("Removing a non-existent guest returns false and does not change list")
    @Test
    public void testRemoveNonExistentGuest() {
        GuestListManager list = new GuestListManager();
        list.addGuest(new Guest("Leah", "Family"));
        boolean removed = list.removeGuest("NotARealGuest");
        assertFalse(removed);
        assertEquals(1, list.getGuestCount());
    }

    @DisplayName("Finding an existing guest returns correct guest object")
    @Test
    public void testFindGuest() {
        GuestListManager list = new GuestListManager();
        Guest guest = new Guest("Leah", "Family");
        list.addGuest(guest);
        Guest search = list.findGuest("Leah");
        assertNotNull(search);
        assertEquals("Leah", search.getName());
    }

    @DisplayName("Guest count reflects number of added guests")
    @Test
    public void testGetGuestCount() {
        GuestListManager list = new GuestListManager();
        assertEquals(0, list.getGuestCount());
        list.addGuest(new Guest("Leah", "Family"));
        assertEquals(1, list.getGuestCount());
    }

    @DisplayName("getAllGuests returns all guests in correct order")
    @Test
    public void testGetAllGuests() {
        GuestListManager list = new GuestListManager();
        list.addGuest(new Guest("Leah", "Family"));
        list.addGuest(new Guest("Libby", "Family"));
        list.addGuest(new Guest("Itty", "Family"));
        List<Guest> guests = list.getAllGuests();
        assertEquals(3, guests.size());
        assertEquals("Leah", guests.get(0).getName());
        assertEquals("Libby", guests.get(1).getName());
        assertEquals("Itty", guests.get(2).getName());
    }

    @DisplayName("getAllGuests returns a copy, not the internal list")
    @Test
    public void testGetAllGuestsReturnsCopy() {
        GuestListManager list = new GuestListManager();
        list.addGuest(new Guest("Leah", "Family"));
        List<Guest> guests = list.getAllGuests();
        guests.clear();
        assertEquals(1, list.getGuestCount(), "Internal list should remain unchanged");
    }
}