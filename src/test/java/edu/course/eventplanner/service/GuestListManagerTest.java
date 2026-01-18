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
        Guest g = new Guest("Leah", "Family");
        list.addGuest(g);
        assertEquals(1, list.getGuestCount());
        assertEquals(g, list.findGuest("Leah"));
    }

    @DisplayName("Removing a guest decreases count and removes lookup entry")
    @Test
    public void testRemoveGuest() {
        GuestListManager list = new GuestListManager();
        list.addGuest(new Guest("Leah", "Family"));
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

    @DisplayName("getAllGuests returns a copy, not the internal list")
    @Test
    public void testGetAllGuestsReturnsCopy() {
        GuestListManager list = new GuestListManager();
        list.addGuest(new Guest("Leah", "Family"));
        List<Guest> guests = list.getAllGuests();
        guests.clear();
        assertEquals(1, list.getGuestCount());
        assertNotNull(list.findGuest("Leah"));
    }

    @Test
    void testFindGuest() {
        GuestListManager manager = new GuestListManager();
        manager.addGuest(new Guest("A", "x"));
        assertNotNull(manager.findGuest("A"));
    }

    @Test
    void testFindGuestNotFound() {
        GuestListManager manager = new GuestListManager();
        assertNull(manager.findGuest("Z"));
    }
}