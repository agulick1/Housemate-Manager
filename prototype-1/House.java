import java.util.ArrayList;
import java.util.List;

public class House {
    public List<Housemate> members;
    public Inventory i;
    public List<Receipt> pastReceipts;

    public House(){
        members = new ArrayList<>();
        i = new Inventory(); //assuming empty constructor ok
        pastReceipts = new ArrayList<>();
    }
    
    public void addHousemate(Housemate h){
        members.add(h);
    }
    
    public void removeHousemate(Housemate h){
        members.remove(h); // not sure if this is the optimal method of removal, make sure to test later TODO**
    }

    public int size(){
        return members.size();
    }

    // Returns a copy of members (for opt-in/out function of receipt)
    public List<Housemate> getHousemates() {
        List<Housemate> mateList = new ArrayList<>(members);
        return mateList;
    }

    public Housemate getHousemate(String s) {
        for (Housemate member : members) {
            String name = member.getName();
            if (s.equals(name)) {
                return member;
            }
        }
        return null;
    }

    public Inventory getInventory() {
        return i;
    }

    public void logReceipt(Receipt r) {
        pastReceipts.add(r);
    }

    // implemented in main to return log of past receipts
    public List<Receipt> getPastReceipts() {
        return pastReceipts;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (Housemate member : members) {
            sb.append(prefix);
            prefix = "\n";
            sb.append(member.getName());
        }
        return sb.toString();
    }
}
