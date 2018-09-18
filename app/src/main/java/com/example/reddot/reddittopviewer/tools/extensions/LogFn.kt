package com.example.reddot.reddittopviewer.tools.extensions

import android.util.Log
import com.example.reddot.reddittopviewer.BuildConfig

private const val TAG = "DEBUG: "
private const val MASSAGE_IS_NULL = "log massage == null"
private val debug: Boolean = BuildConfig.DEBUG

/**
 * Log functions for DEBUG
 */

fun logD(message: String?) = logD(TAG, message)
fun logD(tag: String?, massage: String?) {
    if (debug) Log.d(tag ?: TAG, massage ?: MASSAGE_IS_NULL) // BLUE
}

fun logI(message: String?) = logI(TAG, message)
fun logI(tag: String?, massage: String?) {
    if (debug) Log.i(tag ?: TAG, massage ?: MASSAGE_IS_NULL) // GREEN
}

fun logE(message: String?) = logE(TAG, message)
fun logE(tag: String?, massage: String?) {
    if (debug) Log.e(tag ?: TAG, massage ?: MASSAGE_IS_NULL) // RED
}

fun logV(message: String?) = logV(TAG, message)
fun logV(tag: String?, massage: String?) {
    if (debug) Log.v(tag ?: TAG, massage ?: MASSAGE_IS_NULL) // WHITE
}

fun logW(message: String?) = logW(TAG, message)
fun logW(tag: String?, massage: String?) {
    if (debug) Log.w(tag ?: TAG, massage ?: MASSAGE_IS_NULL) // YELLOW
}

fun logA(message: String?) = logA(TAG, message)
fun logA(tag: String?, massage: String?) {
    if (debug) Log.wtf(tag ?: TAG, massage ?: MASSAGE_IS_NULL) // PURPLE
}