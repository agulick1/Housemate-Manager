package edu.vassar.cmpu203.housematemanager.model;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ReceiptItem {
    // vars
    private String itemID;
    private int quantity;
    private double price;
    // TODO turn debtors into List<String>
    private List<Housemate> debtors;

    public ReceiptItem() {}

    public ReceiptItem(String itemID, int quantity, double price, List<Housemate> debtors) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = Math.round(price * 100) / 100.0;
        this.debtors = new ArrayList<Housemate>(debtors);
    }

    public Boolean paidBy(Housemate debtor) {
        return debtors.contains(debtor);
    }
    public void optOut(Housemate debtor) { debtors.remove(debtor); }
    public void optIn(Housemate debtor) { debtors.add(debtor); }

    public String getItemID() {return itemID;}
    public void setItemID(String itemID) { this.itemID = itemID;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() {return price;}
    public void setPrice(double price) { this.price = Math.round(price * 100) / 100.0; }

    public double eachPays() { return Math.round(price / debtors.size() * 100) / 100.0; }
    public int getDebtorCount() {return debtors.size();}

    public boolean equals(ReceiptItem item) {
        return item.getItemID().equals(this.getItemID());
    }
    public String toString() {return getItemID();}
}
