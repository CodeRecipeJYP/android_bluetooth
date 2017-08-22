package com.asuscomm.yangyinetwork.boilerplate;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jaeyoung on 8/21/17.
 */

class ItemAdapter extends RecyclerView.Adapter {
    private List<BluetoothItem> items1;

    public ItemAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setItems(List<BluetoothItem> items) {
        items1 = items;
    }
}
