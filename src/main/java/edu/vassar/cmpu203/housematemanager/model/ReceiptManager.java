package edu.vassar.cmpu203.housematemanager.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptManager {
    // TODO make past receipts int Map<String, String> where first string is date and second string is receipt.toString()
    private List<Receipt> pastReceipts;
    private Receipt r;

    public ReceiptManager() {
        this.pastReceipts = new ArrayList<>();
    }

    public void startReceipt(Housemate payer, List<Housemate> debtors) {
        this.r = new Receipt(debtors, payer);
    }

    public void endReceipt(Inventory inventory) {
        r.process(inventory);
        pastReceipts.add(r);
        r = null;
    }

    // will return null if there is no ongoing receipt
    public Receipt getReceipt(){
        return r;
    }

    public void setReceipt(Receipt r) { this.r = r; }

    public List<Receipt> getPastReceipts(){
        return new ArrayList<>();
    }

    public void setPastReceipts(List<Receipt> receipts) { this.pastReceipts = receipts;}

    @Override
    public String toString(){
        if(pastReceipts.isEmpty()){return "No Receipts have been logged!";}
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Receipt r : pastReceipts){
            sb.append("Receipt "+ i+": \n"+r.toString()+ "\n");
            i++;
        }
        return sb.toString();
    }
}
