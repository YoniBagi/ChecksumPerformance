package com.checksumperformance

import android.app.Application
import android.content.Context
import android.hardware.usb.UsbManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel

class MainViewModel(private val mApp: Application): AndroidViewModel(mApp) {
    private val mUsbManager: UsbManager = mApp.getSystemService(Context.USB_SERVICE) as UsbManager

    @RequiresApi(Build.VERSION_CODES.S)
    fun onStartClicked() {
        Log.d("UsbManagerTest", "started")
        Log.d("UsbManagerTest", "devices size: ${mUsbManager.deviceList.size}")
        mUsbManager.deviceList?.forEach {
            Log.d("UsbManagerTest", "device: $it")
        }
        Log.d("UsbManagerTest", "accessory size: ${mUsbManager.accessoryList?.size}")
        mUsbManager.accessoryList?.forEach {
            Log.d("UsbManagerTest", "accessory: $it")
        }
    }

    fun onStopClicked(){

    }
}