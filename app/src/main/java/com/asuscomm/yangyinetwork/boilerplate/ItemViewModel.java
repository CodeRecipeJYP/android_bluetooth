package com.asuscomm.yangyinetwork.boilerplate;

import android.databinding.ObservableField;

/**
 * Created by jaeyoung on 8/21/17.
 */

public class ItemViewModel {
    public ObservableField<BluetoothItem> mItem = new ObservableField<>(new BluetoothItem());
}
