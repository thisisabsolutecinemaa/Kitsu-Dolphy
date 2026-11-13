package com.kitsu.dolphy.plugin

import android.content.Context
import java.io.File

class PluginManager(private val context: Context) {
    fun listInstalledPlugins(): List<File> {
        val dir = File(context.filesDir, "plugins")
        if (!dir.exists()) return emptyList()
        return dir.listFiles()?.filter { it.name.endsWith(".dolphyplugin") } ?: emptyList()
    }

    fun registerPlugin(pluginFile: File): Boolean {
        val target = File(context.filesDir, "plugins")
        target.mkdirs()
        val output = File(target, pluginFile.name)
        pluginFile.copyTo(output, overwrite = true)
        return output.exists()
    }
}

class PythonPluginBridge(private val context: Context) {
    fun loadPlugin(pluginFile: File): String {
        return pluginFile.readText(Charsets.UTF_8)
    }
}
