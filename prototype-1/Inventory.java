import java.util.HashMap;
import java.util.*;
import java.lang.StringBuilder;


// hashmap!
// adam

//hashmap(key String, Value Item)


public class Inventory {

    HashMap<String, Item> invent;


    // create a new inventory. will only need to be done once (at the creation of a new house)
    // initializes invent to be a completely empty inventory
    // Hashmap with String Keys and Item Values
    public Inventory() {
        invent = new HashMap<>();
    }


    // addItem:
    // takes a string itemID as an input and an integer quantity
    // if there is already an Item with that itemID in the inventory,
    // it just updates the current quantity
    // if there is no Item with that itemID in inventory, it adds item

    public void addItem(String itemID, int quantity) {
        Item updatedItem;
        if (invent.containsKey(itemID)) {
            updatedItem = invent.get(itemID);
            updatedItem.setCurrent(updatedItem.getCurrent() + quantity);
        } else {
            updatedItem = new Item(itemID, quantity);
            invent.put(itemID, updatedItem);
        }
    }


    // useItem:
    // takes a string itemID as an input and an integer quantity
    // if there is an Item with that itemID in the inventory,
    // it just updates the current quantity with the amount used
    // if there is no Item with that itemID in inventory, or if
    // user says they are using more of an item then they currently have,
    // it throws an exception

    public void useItem(String itemID, int quantity) throws Exception {
        if (invent.containsKey(itemID)
                && (invent.get(itemID).getCurrent() >= quantity)) {
            Item updatedItem = invent.get(itemID);
            updatedItem.setCurrent(updatedItem.getCurrent() - quantity);
        } else
            throw new Exception("You cannot use more of an item than you have");
    }


    // getShoppingList:
    // creates a shopping list based on what's in the inventory
    // iterates through the inventory and for every item for which
    // the current quantity is less than the desired, it adds to shopping list
    // shoppingList is an arrayList of Strings

    public List<Item> getShoppingList() {
        List<Item> ShoppingList = new ArrayList<>();
        for (Item i : invent.values()) {
            if (i.getCurrent() < i.getDesired())
                ShoppingList.add(i);
        }
        return ShoppingList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---Current Inventory---\n");
        sb.append(String.format("%-20s\t%8s%n", "Item", "Quantity"));
        for(Item itm : this.invent.values()) {
            String itemID = itm.getItemID();
            int current = itm.getCurrent();
            sb.append(String.format("%-20s\t%8d%n", itemID, current));
        }
        sb.append("---Shopping List---\n");
        sb.append(String.format("%-20s\t%8s%n", "Item", "Quantity"));
        List<Item> shoppingList = getShoppingList();
        for (Item itm : shoppingList) {
            String itemID = itm.getItemID();
            int needed = itm.getDesired() - itm.getCurrent();
            sb.append(String.format("%-20s\t%8d%n", itemID, needed));
        }
        return sb.toString();
    }

}


