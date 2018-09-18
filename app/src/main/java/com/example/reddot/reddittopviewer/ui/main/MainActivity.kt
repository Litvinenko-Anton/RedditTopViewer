package com.example.reddot.reddittopviewer.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.reddot.reddittopviewer.R
import com.example.reddot.reddittopviewer.model.ClickItemModel
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.PostData
import com.example.reddot.reddittopviewer.tools.Constants.BASE_URL
import com.example.reddot.reddittopviewer.tools.Constants.POST_LIMIT
import com.example.reddot.reddittopviewer.tools.EndlessRecyclerViewScrollListener
import com.example.reddot.reddittopviewer.ui.base.BaseActivity
import com.example.reddot.reddittopviewer.ui.main.adapter.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*
import openChromeCustomTabs
import sharedContentIntent
import showToast

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
                    if (totalItemsCount % POST_LIMIT == 0)
                        mainPresenter.loadPosts()
                }
            }
            layoutManager = lm
            addOnScrollListener(scrollListener)
        }
    }

    private fun initSwipeView() {
        swipe_refresh.setOnRefreshListener {
            mainPresenter.loadPosts()
        }
    }

    private fun subscribeAdapterItemClick(adapter: PostAdapter) {
        addDisposables(adapter.clickEvent.subscribe { onItemClick(it) })
    }

    override fun responseError(errorMessage: String) {
        val position = adapter?.itemCount ?: 0
        rv_posts?.scrollToPosition(position - 1)
    }

    private fun onItemClick(clickItem: ClickItemModel) {
        when (clickItem.id) {
            R.id.tv_title,
            R.id.iv_thumb,
            R.id.ib_browser -> openChromeCustomTabs(BASE_URL + clickItem.model?.permalink)
            R.id.tv_likes_count -> showToast("${clickItem.model?.score} pts")
            R.id.ib_likes -> showToast("Like it!")
            R.id.ib_dislikes -> showToast("Dislike it!")
            R.id.ib_share -> sharedContentIntent(getSharedContent(clickItem.model))
            R.id.btn_try_again -> mainPresenter.loadPosts()

        }
    }


    private fun getSharedContent(model: PostData?): String {
        return "${model?.title}\n${BASE_URL + model?.permalink}"
    }

}
