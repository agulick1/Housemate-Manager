package edu.vassar.cmpu203.housematemanager.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ReceiptTest {
    /*
    Tests addReceiptItem by adding an item, then checking if hasItem returns accordingly
     */
    @Test
    void addReceiptItem() {
        List<Housemate> debtors = new ArrayList<>();
        Housemate payer = new Housemate();
        payer.setName("Rohan");
        Receipt r = new Receipt(debtors, payer);
        r.addItem("Chips", 10, 10);
        assertTrue(r.hasItem("Chips"));
        assertFalse(r.hasItem("Eggs")); // checking false positive
    }

    @Test
    void removeReceiptItem() {
        List<Housemate> debtors = new ArrayList<>();
        Housemate payer = new Housemate();
        payer.setName("Rohan");
        Receipt r = new Receipt(debtors, payer);
        r.addItem("Chips", 10, 10);
        r.rmItem("Chips", 10);
        assertFalse(r.hasItem("Chips"));
    }
    /*
    Tests process() by running process, then checking that it has updated inventory and debts accordingly
     */
    @Test
    void process() {
        Inventory i = new Inventory();
        List<Housemate> debtors = new ArrayList<>();
        Housemate payer = new Housemate();
        payer.setName("Alesio");
        Housemate debtor = new Housemate();
        payer.setName("David");
        debtors.add(debtor);
        Receipt r = new Receipt(debtors, payer);
        r.addItem("Chips",10,10);
        assertEquals("All Debts are Paid!",debtor.getDebtsStringForm()); // checks debtor starts debtless
        r.process(i); // should change the inventory and give the housemate
        assertTrue(i.hasItem("Chips")); // checks the inventory has updated
        assertNotEquals("All Debts are Paid!",debtor.getDebtsStringForm()); // checks a debt has been added
    }
    /*
    Tests toString() by adding variables and checking return value
     */
    @Test
    void emptyToString() {
        List<Housemate> debtors = new ArrayList<>();
        Housemate payer = new Housemate();
        payer.setName("Adam");
        Receipt r = new Receipt(debtors, payer);
        assertEquals("Add items paid by Adam",r.toString()); // tests for empty case
        // adds an item and processes.
        r.addItem("Chips",10,10);
        Inventory i = new Inventory();
        r.process(i);
        assertEquals("10 units of Chips for 10.00\n\nAdam paid total of 10.00",r.toString());
    }
    /*
    Tests toString(Housemate debtor) by adding variables and checking return value
     */
    @Test
    void paramToString() {
        List<Housemate> debtors = new ArrayList<>();
        Housemate payer = new Housemate();
        payer.setName("Adam");
        debtors.add(payer);
        Receipt r = new Receipt(debtors, payer);
        r.addItem("Chips",10,10);
        String expected = "---Paying Items---\n[Chips] each pays 10.00\n\n---Unselected Items---\n\nAdam will owe Adam 10.00";
        assertEquals(expected,r.toString(payer)); // Debtor is payer so debt owed is 0
    }
}