package com.asuscomm.yangyinetwork.boilerplate;

/**
 * Created by jaeyoung on 8/21/17.
 */

public class BluetoothItem {
    public String name;
    public String address;
    public int bondState;

    public BluetoothItem(String name, String address, int bondState) {
        this.name = name;
        this.address = address;
        this.bondState = bondState;
    }

    @Override
    public String toString() {
        return "BluetoothItem{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bondState=" + bondState +
                '}';
    }
}
