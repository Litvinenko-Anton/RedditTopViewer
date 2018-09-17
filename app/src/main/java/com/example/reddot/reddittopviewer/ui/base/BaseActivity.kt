package com.example.reddot.reddittopviewer.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.reddot.reddittopviewer.R
import com.example.reddot.reddittopviewer.ui.interfaces.ActivityScreenSwitcher
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import showToast


abstract class BaseActivity : MvpAppCompatActivity(), ActivityScreenSwitcher {

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startNoAnim()
    }

    override fun onDestroy() {
        disposables.apply {
            dispose()
            clear()
        }
        super.onDestroy()
    }

    protected fun addDisposables(vararg ds: Disposable) = ds.forEach { disposables.add(it) }

    private fun startNoAnim() {
        overridePendingTransition(R.anim.no_anim, R.anim.no_anim)
    }

    override fun nextActivity(activityIntent: Intent) {
        startActivity(activityIntent)
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            if (supportFragmentManager.backStackEntryCount == 1)
                super.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

    override fun nextFragment(fragment: Fragment, @IdRes containerViewId: Int, TAG: String) {
        nextFragmentAnim(fragment, containerViewId, TAG, R.anim.enter_from_right, R.anim.exit_to_right)
    }

    fun nextFragmentAnim(fragment: Fragment, @IdRes containerViewId: Int, TAG: String, enterAnimRes: Int, exitAnimRes: Int) {
        nextFragmentAnim(fragment, containerViewId, TAG, enterAnimRes, exitAnimRes, enterAnimRes, exitAnimRes)
    }

    fun nextFragmentAnim(fragment: Fragment, @IdRes containerViewId: Int, TAG: String, enterAnimRes: Int, exitAnimRes: Int, enterPopAnimRes: Int, exitPopAnimRes: Int) {
        if (supportFragmentManager.findFragmentByTag(TAG) == null)
            nextFragmentAddStack(fragment, containerViewId, TAG, enterAnimRes, exitAnimRes, enterPopAnimRes, exitPopAnimRes)
    }

    fun goToFragmentAnim(fragment: Fragment, @IdRes containerViewId: Int, TAG: String, enterAnimRes: Int, exitAnimRes: Int, enterPopAnimRes: Int, exitPopAnimRes: Int) {
        val fragmentTag = supportFragmentManager.findFragmentByTag(TAG)
        if (fragmentTag == null)
            nextFragmentAddStack(fragment, containerViewId, TAG, enterAnimRes, exitAnimRes, enterPopAnimRes, exitPopAnimRes)
        else if (fragmentTag.tag != getActiveFragment()?.tag)
            returnToOldFragmentInStack(TAG)
    }

    fun nextFragmentAddStack(fragment: Fragment, @IdRes containerViewId: Int, TAG: String, enterAnimRes: Int, exitAnimRes: Int) {
        nextFragmentAddStack(fragment, containerViewId, TAG, enterAnimRes, exitAnimRes, enterAnimRes, exitAnimRes)
    }

    fun nextFragmentAddStack(fragment: Fragment, @IdRes containerViewId: Int, TAG: String, enterAnimRes: Int, exitAnimRes: Int, enterPopAnimRes: Int, exitPopAnimRes: Int) {
        if (supportFragmentManager.findFragmentByTag(TAG) == null)
            supportFragmentManager.beginTransaction()
                    .setCustomAnimations(enterAnimRes, exitAnimRes, enterPopAnimRes, exitPopAnimRes)
                    .add(containerViewId, fragment, TAG)
                    .addToBackStack(TAG)
                    .commit()
    }

    fun returnToOldFragmentInStack(TAG: String) {
        supportFragmentManager.popBackStack(TAG, 0)
    }

    fun getActiveFragment(): Fragment? {
        if (supportFragmentManager.backStackEntryCount == 0) {
            return null
        }
        val tag = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
        return supportFragmentManager.findFragmentByTag(tag) as Fragment
    }

    open fun responseError(errorMessage: String) {
        showToast(errorMessage)
    }

}