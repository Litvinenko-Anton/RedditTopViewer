package com.example.reddot.reddittopviewer.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.reddot.reddittopviewer.R
import com.example.reddot.reddittopviewer.model.ClickItemModel
import com.example.reddot.reddittopviewer.tools.Constants.BASE_URL
import com.example.reddot.reddittopviewer.ui.adapter.EndlessRecyclerViewScrollListener
import com.example.reddot.reddittopviewer.ui.adapter.PostAdapter
import com.example.reddot.reddittopviewer.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import openChromeCustomTabs

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter
    private var adapter: PostAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initSwipeView()
        swipe_refresh.isRefreshing = true
        mainPresenter.loadFirstPosts()
    }

    override fun initAdapter(adapter: PostAdapter) {
        this.adapter = adapter
        rv_posts?.apply {
            this.adapter = adapter
            subscribeAdapterItemClick(adapter)
        }
    }

    override fun hideProgress() {
        if (swipe_refresh.isRefreshing)
            swipe_refresh.isRefreshing = false
    }

    private fun initRecyclerView() {
        rv_posts?.apply {
            val lm = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
            val scrollListener = object : EndlessRecyclerViewScrollListener(lm) {
                // Scroll to loadMore
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    mainPresenter.loadMorePosts()
                }
            }
            layoutManager = lm
            addOnScrollListener(scrollListener)
        }
    }

    private fun initSwipeView() {
        swipe_refresh.setOnRefreshListener {
            adapter?.skipList()
            mainPresenter.loadFirstPosts()
        }
    }

    private fun subscribeAdapterItemClick(adapter: PostAdapter) {
        addDisposables(adapter.clickEvent.subscribe { onItemClick(it) })
    }

    private fun onItemClick(clickItem: ClickItemModel) {
        when (clickItem.id) {
            R.id.iv_thumb -> openChromeCustomTabs(BASE_URL + clickItem.model.permalink)
//            R.id.shareImageButton -> sharedContent(context!!, clickItem.model)
//            R.id.parentView -> showToast(clickItem.model.title)
        }
    }

}
