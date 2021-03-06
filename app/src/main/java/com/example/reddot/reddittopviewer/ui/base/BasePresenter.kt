package com.example.reddot.reddittopviewer.ui.base

import com.arellomobile.mvp.MvpPresenter
import com.example.reddot.reddittopviewer.di.InjectHelper
import com.example.reddot.reddittopviewer.repository.RepositoryImp
import com.example.reddot.reddittopviewer.tools.Constants.UNKNOWN_ERROR
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<view : BaseView> : MvpPresenter<view>() {

    private val disposables = CompositeDisposable()
    protected var repository: RepositoryImp = InjectHelper().repository

    override fun onDestroy() {
        disposables.apply {
            dispose()
            clear()
        }
        super.onDestroy()
    }

    protected fun addDisposables(vararg ds: Disposable) = ds.forEach { disposables.add(it) }

    protected open fun showProgress() = viewState.showProgress()

    protected open fun hideProgress() = viewState.hideProgress()

    protected open fun onCompleted() {
        viewState.responseComplete()
        viewState.hideProgress()
    }

    protected open fun onError(throwable: Throwable) {
        throwable.printStackTrace()
        onError(throwable.message ?: UNKNOWN_ERROR)
    }

    protected open fun onError(errorMessage: String) {
        viewState.hideProgress()
        viewState.responseError(errorMessage)
    }
}
