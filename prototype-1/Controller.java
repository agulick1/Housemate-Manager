public class Controller {
    static House house = new House();
    Receipt r;

    public void addHousemate(String name) {
        house.addHousemate(new Housemate(name));
    }
    public void removeHousemate(String name) {
        house.removeHousemate(house.getHousemate(name));
    }
    public String viewHousemates() {
        return house.toString();
    }
    public void viewInventory() {
        System.out.println(house.getInventory().toString()); 
    }
    public void startReceipt(String name) { // asssumes name is a valid name
        Housemate payer = house.getHousemate(name);
        r = new Receipt(house, payer);
    }
    public void addReceipt(String id, int quant, double price) {
        r.addReceiptItem(id, quant, price);
    }
    public void endReceipt() {
        r.process();
    }

    public void viewReceipts() {
        System.out.println(house.getPastReceipts().toString());
    }
    public void addDebt(String debtor, String creditor, double debt) {
        house.getHousemate(debtor).addDebt(house.getHousemate(creditor), debt);
    }
}
