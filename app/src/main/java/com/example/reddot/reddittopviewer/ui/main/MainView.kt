package com.example.reddot.reddittopviewer.ui.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.reddot.reddittopviewer.ui.main.adapter.PostAdapter
import com.example.reddot.reddittopviewer.ui.base.BaseView

/**
 * MainPresenter -> ViewState
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : BaseView {
    fun initAdapter(adapter: PostAdapter)
}