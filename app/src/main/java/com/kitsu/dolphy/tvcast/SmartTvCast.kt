package com.kitsu.dolphy.tvcast

import android.content.Context

class SmartTvCast(private val context: Context) {
    fun discoverDevices(): List<String> {
        return listOf("Living Room TV", "Bedroom TV")
    }

    fun castToDevice(deviceName: String, contentUrl: String) {
        // расширение для Cast/DLNA/SSDP
    }
}
