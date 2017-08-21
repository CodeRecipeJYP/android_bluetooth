package com.asuscomm.yangyinetwork.boilerplate;

import android.arch.lifecycle.ViewModelProviders;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuscomm.yangyinetwork.boilerplate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initBluetooth();
    }

    private void initView() {
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setMainviewmodel(new MainViewModel());
    }

    private void initBluetooth() {

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // Device does not support Bluetooth
            Log.d(TAG, "initBluetooth: notSupported");
        } else {
            mViewModel.setBluetoothAdapter(bluetoothAdapter);
            mViewModel.activate();
        }
    }
}
