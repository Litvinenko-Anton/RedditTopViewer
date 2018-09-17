package com.example.reddot.reddittopviewer.tools.extensions

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Schedulers.ui(): Scheduler = AndroidSchedulers.mainThread()