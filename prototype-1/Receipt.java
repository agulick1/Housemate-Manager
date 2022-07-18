import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


public class Receipt {
    public House h;
    public Housemate payer;
    public List<ReceiptItem> itemList;

    public Receipt(House h, Housemate payer) {
        this.h = h;
        this.payer = payer;
        this.itemList = new ArrayList<>();
    }

    public void addReceiptItem(String itemID, int quantity, double price) {
        List<Housemate> debtors = h.getHousemates();
        ReceiptItem itm = new ReceiptItem(itemID, quantity, price, debtors);
        itemList.add(itm);
    }

    public double getTotal() {
        double total = 0;
        for (ReceiptItem itm : itemList) {
            total += itm.getPrice();
        }
        return total;
    }

    // iteration 1: evenly divide up the price and give debt to everyone except payer
    private void chargeHousemates(ReceiptItem itm) {
        List<Housemate> debtors = itm.getDebtors();
        double debt = itm.getPrice() / debtors.size();
        debt = Math.round(debt * 100) / 100;
        debtors.remove(payer);
        for (Housemate debtor : debtors) {
            debtor.addDebt(payer, debt);
        }        
    }

    private void stockInventory(Inventory i, ReceiptItem itm) {
        String id = itm.getItemID();
        int quantity = itm.getQuantity();
        i.addItem(id, quantity);
    }

    // Wrapper for charging debts and stocking items + logging
    public void process() {
        Inventory i = h.getInventory();
        for (ReceiptItem itm : itemList) {
            chargeHousemates(itm);
            stockInventory(i, itm);
        }
        h.logReceipt(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%-20s\t%8s\t%5s%n", "Item", "Quantity", "Price"));
        for (ReceiptItem itm : this.itemList) {
            String itemID = itm.getItemID();
            int quantity = itm.getQuantity();
            double price = itm.getPrice();
            str.append(String.format("%-20s\t%8d\t%5.2f%n", itemID, quantity, price));
        }
        str.append(payer.getName() + " paid total of " + String.format("%.2f", getTotal()) + "\n");
        return str.toString();

    }

}
