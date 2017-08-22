package com.asuscomm.yangyinetwork.boilerplate;

import android.arch.lifecycle.ViewModel;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jaeyoung on 8/21/17.
 */

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";

    @NonNull public ObservableField<List<BluetoothItem>> mItems = new ObservableField<>(new ArrayList<>());
    @NonNull public ObservableField<Boolean> mOnoffState = new ObservableField<>(false);
    private BluetoothAdapter mBluetoothAdapter;

    public MainViewModel() {
    }

    public void setBluetoothAdapter(BluetoothAdapter mBluetoothAdapter) {
        this.mBluetoothAdapter = mBluetoothAdapter;
    }

    public void activate() {
        if (mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
            mOnoffState.set(true);
        } else {
            mOnoffState.set(true);
        }

        getBondedDevices();
    }

    private List<BluetoothItem> convertToBluetoothItem(Set<BluetoothDevice> bondedDevices) {
        List<BluetoothItem> items = new ArrayList<>();

        for (BluetoothDevice item :
                bondedDevices) {
            String name = item.getName();
            int bondState = item.getBondState();
            String address = item.getAddress();
            BluetoothItem bluetoothItem = new BluetoothItem(name, address, bondState);
            items.add(bluetoothItem);
        }

        return items;
    }

    public void getBondedDevices() {
        Set<BluetoothDevice> bondedDevices = mBluetoothAdapter.getBondedDevices();
        List<BluetoothItem> bluetoothItems = convertToBluetoothItem(bondedDevices);
        Log.d(TAG, "activate: " + bluetoothItems.toString());

        mItems.set(bluetoothItems);
    }
}
