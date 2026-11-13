package com.kitsu.dolphy.hid

import android.app.Service
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothHidDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder

class KeyboardService : Service() {
    private var adapter: BluetoothAdapter? = null
    private var hidDeviceProxy: BluetoothHidDevice? = null

    override fun onBind(intent: Intent?): IBinder? = null

    fun initHid() {
        val manager = getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        adapter = manager?.adapter
    }

    fun connectHost(device: BluetoothDevice) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            hidDeviceProxy?.connect(device)
        }
    }
}
