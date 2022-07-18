import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Starting...");
        Controller controller = new Controller();
        System.out.println("House initialized");
        System.out.println("Enter # of housemates: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Housemate # " + (i + 1));
            System.out.println("Enter name: ");
            controller.addHousemate(input.next());
            System.out.println("Added!");
        } // initialization of house... adding initial housemates.

        while (true) { // General function loop
            try {
                System.out.println("Select your activity (type the number):");
                System.out.println("0. Quit");
                System.out.println("1. Add a Housemate");
                System.out.println("2. Remove a Housemate");
                System.out.println("3. View Housemates");
                System.out.println("4. View Inventory");
                System.out.println("5. Start receipt"); // this name is weird change it later
                System.out.println("6. View past receipts");
                System.out.println("7. Add debt");
                int response = input.nextInt();
                if (response == 0) {
                    System.out.println("Closing...");
                    break; // because breaks don't work the same in switches
                } else {
                    switch (response) {
                        case 1: // Adding housemate
                            System.out.println("---ADDING HOUSEMATE---");
                            System.out.println("Enter housemate name: ");
                            String name = input.next();
                            controller.addHousemate(name);
                            System.out.println("---DONE---");
                            break;
                        case 2:
                            System.out.println("---REMOVING HOUSEMATE---");
                            System.out.println("Enter name: ");
                            String n = input.next();
                            if (n == null) {
                                System.out.println("Invalid name!");
                            } else if (controller.viewHousemates().contains(n)) {
                                controller.removeHousemate(n);
                                System.out.println("Successfully removed.");
                            } else System.out.println("Invalid name!");
                            System.out.println("---DONE---");
                            break;
                        case 3:
                            System.out.println("---VIEW HOUSEMATES---");
                            System.out.println(controller.viewHousemates());
                            System.out.println("---DONE---");
                            break;
                        case 4:
                            System.out.println("---VIEW INVENTORY---");
                            controller.viewInventory();
                            System.out.println("---DONE---");
                            break;
                        case 5:
                            System.out.println("---START RECEIPT---");
                            System.out.println("Enter Housemate that paid for receipt:");
                            name = input.next();
                            if (!controller.viewHousemates().contains(name)) {
                                System.out.println("Invalid name!");
                            } else {
                                controller.startReceipt(input.next());
                                System.out.println("Enter number of items:");
                                int receiptNum = input.nextInt();
                                for (int i = 0; i < receiptNum; i++) {
                                    System.out.println("Enter the item Name:");
                                    String id = input.next();
                                    System.out.println("Enter the quantity of " + id + "s:");
                                    int quant = input.nextInt();
                                    System.out.println("Enter the price of " + quant + " " + id + "s:");
                                    double price = input.nextDouble();
                                    controller.addReceipt(id, quant, price);
                                }
                                controller.endReceipt();
                            }
                            System.out.println("---DONE---");
                            break;
                        case 6:
                            System.out.println("---VIEW RECEIPTS---");
                            controller.viewReceipts();
                            System.out.println("---DONE---");
                            break;
                        case 7:
                            System.out.println("---ADD DEBT---");
                            System.out.println("Enter debtor (person who owes):");
                            String debtor = input.next();
                            System.out.println("Enter creditor: (person owed)");
                            String creditor = input.next();
                            System.out.println("Enter debt:");
                            double debt = input.nextDouble();
                            controller.addDebt(debtor, creditor, debt);
                            System.out.println("---DONE---");
                        default:
                            System.out.println("Error - bad command");
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
                input.next();
            }
        }
    }
}
