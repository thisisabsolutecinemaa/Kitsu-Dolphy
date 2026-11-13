package com.kitsu.dolphy.tvcast

import android.content.Context

class SmartTvCast(private val context: Context) {
    fun discoverDevices(): List<String> {
        // Здесь обычно используется Cast SDK / DLNA / SSDP.
        // Для базовой структуры достаточно списка найденных устройств.
        return listOf("Living Room TV", "Bedroom TV")
    }

    fun castToDevice(deviceName: String, contentUrl: String) {
        // Пример точки расширения для кастинга.
    }
}
