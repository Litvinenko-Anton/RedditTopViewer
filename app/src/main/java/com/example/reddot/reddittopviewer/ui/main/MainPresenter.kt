package com.example.reddot.reddittopviewer.ui.main

import com.arellomobile.mvp.InjectViewState
import com.example.reddot.reddittopviewer.tools.Constants.POST_LIMIT
import com.example.reddot.reddittopviewer.tools.Constants.POST_MAX_COUNT
import com.example.reddot.reddittopviewer.tools.extensions.logD
import com.example.reddot.reddittopviewer.ui.base.BasePresenter
import com.example.reddot.reddittopviewer.ui.main.adapter.PostAdapter


@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    val adapter = PostAdapter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initAdapter(adapter)
        loadPosts()
    }

    fun loadPosts() {
        if (adapter.after.isNullOrEmpty())
            loadFirstPosts()
        else
            loadMorePosts()
    }

    private fun loadFirstPosts() {
        if (adapter.itemCount < POST_MAX_COUNT)
            addDisposables(
                    repository.getTopPosts(POST_LIMIT)
                            .doOnRequest { showProgress() }
                            .subscribe({ response ->
                                logD("setupList " + response.data.children.size)
                                adapter.setupList(response.data)
                            }, { t -> onError(t) },
                                    { onCompleted() }
                            )
            )
    }

    private fun loadMorePosts() {
        if (adapter.itemCount < POST_MAX_COUNT)
            addDisposables(
                    repository.getTopPostsPagination(POST_LIMIT, adapter.after)
                            .doOnRequest { showProgress() }
                            .subscribe({ response ->
                                logD("updateList " + response.data.children.size)
                                adapter.updateList(response.data)
                            }, { t -> onError(t) },
                                    { onCompleted() }
                            )
            )
    }

    override fun showProgress() {
        adapter.onProgress()
        super.showProgress()
    }

    override fun onCompleted() {
        adapter.onComplete()
        super.onCompleted()
    }

    override fun onError(throwable: Throwable) {
        val message = throwable.message ?: "Unknown error"
        adapter.onError("Error: $message")
        viewState.responseError(message)
        super.onError(throwable)
    }


}