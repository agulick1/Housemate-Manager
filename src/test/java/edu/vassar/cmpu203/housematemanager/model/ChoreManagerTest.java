package edu.vassar.cmpu203.housematemanager.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ChoreManagerTest {

    /*
    Tests assignChore() by assigning chores and comparing the ChoreList to another identical one.
    Also tests exception handling by intentionally trying to add a duplicate chore.
     */
    @Test
    void assignChore() {
        ChoreManager cm = new ChoreManager();
        // testing addition
        cm.assignChore("Laundry", "Margaret", "Frank"); // assigns chore
        List<Chore> l = new ArrayList<>(); // Creates list and adds identical chore for comparison
        l.add(new Chore("Laundry", "Margaret", "Frank"));
        assertEquals(l.toString(), cm.getChoreList().toString(), "assigned data incorrect"); // test

        //testing duplicate input error throwing
        try {
            cm.assignChore("Laundry", "Margaret", "Frank");
            fail("Should have thrown an exception");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

    /*
    Tests removeChore() by adding and removing a chore, then checking to see if the chore list is empty.
     */
    @Test
    void removeChore() {
        ChoreManager cm = new ChoreManager();
        cm.assignChore("Laundry", "Margaret", "Frank"); // assigns chore
        cm.removeChore("Laundry"); // name only remove
        assertEquals("[]", cm.getChoreList().toString());

        cm.assignChore("Laundry", "Margaret", "Frank"); // assigns chore
        cm.removeChore("Laundry", "Margaret", "Frank"); // full info remove
        assertEquals("[]", cm.getChoreList().toString());
    }

    /*
    Tests getChoreList() by assigning several chores and checking that getChoreList returns the appropriate output
     */
    @Test
    void getChoreList() {
        ChoreManager cm = new ChoreManager();
        cm.assignChore("Laundry", "Margaret", "Frank");
        cm.assignChore("Dishes", "Pierce", "Klinger");
        cm.assignChore("CMPU203 Homework", "Walter", "Sherman");
        assertEquals("[Laundry Assigned by Margaret to Frank, Dishes Assigned by Pierce to Klinger, CMPU203 Homework Assigned by Walter to Sherman]", cm.getChoreList().toString());
    }

    /*
    Tests getChoreListNames() by assigning several chores and checking the method call returns the appropriate output
     */
    @Test
    void getChoreListNames() {
        ChoreManager cm = new ChoreManager();
        cm.assignChore("Laundry", "Margaret", "Frank");
        cm.assignChore("Dishes", "Pierce", "Klinger");
        cm.assignChore("CMPU203 Homework", "Walter", "Sherman");
        String[] a = {"Laundry", "Dishes", "CMPU203 Homework"};
        for (int i = 0; i < a.length; i++)
            assertEquals(a[i], cm.getChoreListNames().get(i));
    }

    /*
    Tests toString by adding chores to the manager then testing if the output is correct
     */
    @Test
    void testToString() {
        ChoreManager cm = new ChoreManager();
        cm.assignChore("Laundry", "Margaret", "Frank");
        cm.assignChore("Dishes", "Pierce", "Klinger");
        cm.assignChore("CMPU203 Homework", "Walter", "Sherman");
        String temp = "Laundry Assigned by Margaret to Frank\nDishes Assigned by Pierce to Klinger\nCMPU203 Homework Assigned by Walter to Sherman\n";
        assertEquals(temp, cm.toString());
    }
}