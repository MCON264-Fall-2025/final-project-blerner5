package edu.course.eventplanner.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GuestTest {
    @Test
    void testVenueFields() {
        Venue v = new Venue("V", 100, 10, 5, 2);
        assertEquals("V", v.getName());
        assertEquals(100, v.getCost());
        assertEquals(10, v.getCapacity());
    }

    @Test
    void testGuestFields() {
        Guest guest = new Guest("A", "desc");
        assertEquals("A", guest.getName());
        assertEquals("desc", guest.getGroupTag());
    }
}
