package edu.vassar.cmpu203.housematemanager.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HouseTest {
    /*
    Tests addHousemate() by adding a housemate then using getHousemate() to confirm the housemate was added
    Also tries inserting a housemate twice to test duplication protection
     */
    @Test
    void addHousemate() {
        House h = new House();
        h.addHousemate("Rohan");
        assertFalse(h.addHousemate("Rohan")); // Duplication prevention test
        assertNotNull(h.getHousemate("Rohan"));
        assertNull(h.getHousemate("Adam")); // to make sure the getHousemate method is not returning a false positive
    }
    /*
    Tests removeHousemate() by adding two housemates, then removing them one at a time to see if they are deleted properly
    Also tests to make sure housemates who do not exist cannot be removed.
     */
    @Test
    void removeHousemate() {
        House h = new House();
        h.addHousemate("Adam");
        h.addHousemate("David");
        h.removeHousemate("Adam");
        assertNotEquals("[]", h.getHousemates().toString()); // using two housemates to make sure the method doesn't just clear everything
        assertTrue(h.removeHousemate("David")); // also tests boolean return for invalid removal
        assertEquals("[]", h.getHousemates().toString());
        assertFalse(h.removeHousemate("Rohan")); // test for invalid removal
    }
    /*
    Tests toString() by checking if the empty return is correct, then adding housemates and checking if that return is correct
     */
    @Test
    void testToString() {
        House h = new House();
        assertEquals("No Housemates", h.toString());
        h.addHousemate("Alesio");
        h.addHousemate("Adam");
        assertEquals("Alesio\nAdam", h.toString());
    }
}