package com.kitsu.dolphy.ir

import android.content.Context
import android.hardware.ConsumerIrManager

object IrBackend {
    fun isAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONSUMER_IR_SERVICE) as? ConsumerIrManager
        return manager?.hasIrEmitter() == true
    }

    fun transmit(context: Context, button: IrButton): Boolean {
        val manager = context.getSystemService(Context.CONSUMER_IR_SERVICE) as? ConsumerIrManager ?: return false
        if (!manager.hasIrEmitter()) return false
        if (button.pattern.isEmpty() || button.frequency <= 0) return false
        return runCatching {
            manager.transmit(button.frequency, button.pattern)
            true
        }.getOrElse { false }
    }
}
