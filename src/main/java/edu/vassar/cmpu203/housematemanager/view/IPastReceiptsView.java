package edu.vassar.cmpu203.housematemanager.view;

import edu.vassar.cmpu203.housematemanager.model.House;
import edu.vassar.cmpu203.housematemanager.model.ReceiptManager;

public interface IPastReceiptsView {

    interface Listener{
        //TODO implement the method below like receiptProcess
        // void onPastReceiptSelected(IReceiptProcessView receiptProcessView)
    }
    void updateDisplay(ReceiptManager receiptManager);
}
