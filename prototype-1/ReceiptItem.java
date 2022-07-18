import java.util.*;

public class ReceiptItem {
    // vars
    private final String itemID;
    private final int quantity;
    private final double price;
    private List<Housemate> debtors;

    public ReceiptItem(String itemID, int quantity, double price, List<Housemate> debtors) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.debtors = debtors;
    }

    //todo: way to edit debtors

    public String getItemID() {return itemID;}
    public int getQuantity() {return quantity;}
    public double getPrice() {return price;}
    public List<Housemate> getDebtors() {return debtors;}
}
