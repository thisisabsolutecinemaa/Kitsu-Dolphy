package com.kitsu.dolphy.network

import java.net.InetAddress

class LanScanner {
    fun pingSweep(network: String): List<String> {
        val base = network.substringBeforeLast(".") + "."
        val hosts = mutableListOf<String>()
        for (i in 1..254) {
            val address = "$base$i"
            val reachable = runCatching { InetAddress.getByName(address).isReachable(1000) }
                .getOrElse { false }
            if (reachable) hosts += address
        }
        return hosts
    }
}
