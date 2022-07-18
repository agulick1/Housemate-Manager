import java.util.HashMap;

public class Housemate {

    String name;
    HashMap<Housemate, Double> debts;
    
    public Housemate(String name){
        this.name = name;
        this.debts = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    // used in manager
    public String getDebts() { return debts.toString();}

    //todo.. how to implement debt changing? direct change or using a method?
    // implemented with hashmap
    public void addDebt(Housemate creditor, double debt) {
        if (debts.containsKey(creditor)) {
            debts.put(creditor, debts.get(creditor) + debt);
        } else {
            debts.put(creditor, debt);
        }
    }
}
