package com.example.reddot.reddittopviewer

import android.app.Application
import android.content.Context
import com.arellomobile.mvp.MvpFacade

class App : Application() {

    companion object {
        lateinit var appContext: Context
    }

    init {
        appContext = this@App
    }

    override fun onCreate() {
        super.onCreate()
        MvpFacade.init()
    }


}