package com.example.reddot.reddittopviewer.ui.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import showToast


abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        disposables.apply {
            dispose()
            clear()
        }
        super.onDestroy()
    }

    protected fun addDisposables(vararg ds: Disposable) = ds.forEach { disposables.add(it) }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun responseComplete() {

    }

    override fun responseError(errorMessage: String) {
        showToast(errorMessage)
    }
}