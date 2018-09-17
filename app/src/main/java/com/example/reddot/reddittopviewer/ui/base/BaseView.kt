package com.example.reddot.reddittopviewer.ui.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * BasePresenter -> ViewState
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface BaseView : MvpView {

    fun showProgress()

    fun hideProgress()

    fun responseComplete()

    fun responseError(errorMessage: String)

}