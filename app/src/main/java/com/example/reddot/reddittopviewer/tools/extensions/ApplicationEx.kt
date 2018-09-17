package com.example.reddot.reddittopviewer.tools.extensions

import android.app.Application
import android.support.annotation.StringRes
import showToast
import toastD

fun Application.showToast(@StringRes resId: Int) = applicationContext.showToast(resId)

fun Application.showToast(message: String?) = applicationContext.showToast(message)

fun Application.toastD(message: String?) = applicationContext.toastD(message)