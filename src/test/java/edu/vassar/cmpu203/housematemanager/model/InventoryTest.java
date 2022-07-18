package edu.vassar.cmpu203.housematemanager.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryTest {
    /*
    Tests addItem() by adding an item, then checking if the inventory kept it with hasItem()
     */
    @Test
    void addItem() {
        Inventory i = new Inventory();
        i.addItem("Chips", 10);
        assertTrue(i.hasItem("Chips"));
        assertFalse(i.hasItem("Eggs"));
    }
    /*
    Tests useItem() by adding then using an item, and checking if the inventory has updated accordingly
     */
    @Test
    void useItem() {
        Inventory i = new Inventory();
        i.addItem("Chips", 10);
        i.subDesired("Chips",10);
        i.useItem("Chips", 10);
        assertFalse(i.hasItem("Chips"));
    }
    /*
    Adds an item, then checks if the item is there.
    Also checks that calling on item that doesn't exist returns properly
     */
    @Test
    void hasItem() {
        Inventory i = new Inventory();
        i.addItem("Chips",10);
        assertTrue(i.hasItem("Chips"));
        assertFalse(i.hasItem("Eggs"));
    }
    /*
    Tests if the empty toString() return is correct, then adds items and tests if return is still correct
     */
    @Test
    void testToString() {
        Inventory i = new Inventory();
        assertEquals("Nothing in inventory", i.toString());
        i.addItem("Chips", 10);
        i.addItem("Eggs", 15);
        assertEquals("  10 units of Chips\n  15 units of Eggs\n", i.toString());
    }
}
