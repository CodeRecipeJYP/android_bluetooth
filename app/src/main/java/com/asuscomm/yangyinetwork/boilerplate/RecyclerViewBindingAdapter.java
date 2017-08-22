package com.asuscomm.yangyinetwork.boilerplate;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

/**
 * Created by jaeyoung on 8/21/17.
 */

public class RecyclerViewBindingAdapter {
    private static final String TAG = "RecyclerViewBindingAdap";

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<BluetoothItem> items) {
//        Log.d(TAG, "setItemsFromXml() called with: recyclerView = [" + recyclerView
//                + "], items = [" + items + "]");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof ItemAdapter) {
            ((ItemAdapter) recyclerView.getAdapter()).setItems(items);
        } else {
            Log.w(TAG, "setItems: adapter instance is not ItemAdapter");
        }
    }
}
