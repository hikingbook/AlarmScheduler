package com.carterchen247.alarmscheduler.extension

import android.os.Bundle
import androidx.core.os.bundleOf
import android.util.Log

fun Bundle?.toMap(): Map<String, Any?> {
    if (this == null) {
        return emptyMap()
    }
    val hashMap = HashMap<String, Any?>()
    try {
        keySet().forEach { key ->
            hashMap[key] = get(key)
        }
    } catch (e: Exception) {
        Log.e("BundleExtension", "Failed to convert Bundle to Map", e)
    }
    return hashMap
}

fun Map<String, Any?>.toBundle() = bundleOf(*this.toList().toTypedArray())