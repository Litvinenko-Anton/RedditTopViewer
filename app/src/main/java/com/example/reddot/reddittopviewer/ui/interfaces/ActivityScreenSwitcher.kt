package com.example.reddot.reddittopviewer.ui.interfaces

import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.Fragment

interface ActivityScreenSwitcher {

    fun nextFragment(fragment: Fragment, @IdRes containerViewId: Int, TAG: String)

    fun nextActivity(activityIntent: Intent)

    fun onBackPressed()

}