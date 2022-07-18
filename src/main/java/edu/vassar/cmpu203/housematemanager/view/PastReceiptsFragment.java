package edu.vassar.cmpu203.housematemanager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.housematemanager.databinding.FragmentPastReceiptsBinding;
import edu.vassar.cmpu203.housematemanager.model.House;
import edu.vassar.cmpu203.housematemanager.model.ReceiptManager;


public class PastReceiptsFragment extends Fragment implements IPastReceiptsView{

    private final ReceiptManager receiptManager;
    FragmentPastReceiptsBinding binding;
    Listener listener;
    House house;

    public PastReceiptsFragment(Listener listener, ReceiptManager receiptManager) {this.listener = listener; this.receiptManager = receiptManager;}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentPastReceiptsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            this.updateDisplay(this.receiptManager);
    }

    @Override
    public void updateDisplay(ReceiptManager receiptManager) {

        String s = receiptManager.toString();
        this.binding.pastReceiptsTextView.setText(s);
    }

}