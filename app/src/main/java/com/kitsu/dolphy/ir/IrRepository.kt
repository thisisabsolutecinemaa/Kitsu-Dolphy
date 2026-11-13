package com.kitsu.dolphy.ir

import android.content.Context
import java.io.File

data class IrButton(
    val name: String,
    val frequency: Int,
    val protocol: String,
    val pattern: IntArray,
    val raw: String
)

object IrRepository {
    fun parseIrText(rawText: String): List<IrButton> {
        val out = mutableListOf<IrButton>()
        val lines = rawText.lines()

        var name: String? = null
        var frequency = 38000
        var protocol: String? = null
        var raw: String? = null
        var pattern: IntArray? = null

        for (line in lines) {
            val trimmed = line.trim()
            when {
                trimmed.startsWith("name:") -> name = trimmed.removePrefix("name:").trim()
                trimmed.startsWith("frequency:") -> {
                    frequency = trimmed.removePrefix("frequency:").trim().toIntOrNull() ?: frequency
                }
                trimmed.startsWith("protocol:") -> {
                    protocol = trimmed.removePrefix("protocol:").trim()
                }
                trimmed.startsWith("data:") -> {
                    raw = trimmed.removePrefix("data:").trim()
                    val values = raw!!.split(Regex("\\s+"))
                        .mapNotNull { it.toIntOrNull() }
                    pattern = values.toIntArray()
                }
            }
        }

        if (name == null || pattern == null || pattern!!.isEmpty()) return out

        out += IrButton(
            name = name!!,
            frequency = frequency,
            protocol = protocol ?: "RAW",
            pattern = pattern!!,
            raw = raw ?: ""
        )
        return out
    }

    fun parseIrAsset(context: Context, assetPath: String): List<IrButton> {
        val fileText = context.assets.open(assetPath).bufferedReader(Charsets.UTF_8).use { it.readText() }
        return parseIrText(fileText)
    }

    fun parseIrFile(file: File): List<IrButton> {
        return parseIrText(file.readText(Charsets.UTF_8))
    }

    fun listAssetFiles(context: Context, root: String = "Flipper-IRDB-main"): List<String> {
        val result = mutableListOf<String>()
        fun walk(dir: String) {
            val entries = context.assets.list(dir) ?: return
            for (entry in entries) {
                val path = if (dir.isBlank()) entry else "$dir/$entry"
                val children = context.assets.list(path)
                if (children.isNullOrEmpty()) {
                    if (path.endsWith(".ir", ignoreCase = true)) {
                        result += path
                    }
                } else {
                    walk(path)
                }
            }
        }
        walk(root)
        return result
    }
}
