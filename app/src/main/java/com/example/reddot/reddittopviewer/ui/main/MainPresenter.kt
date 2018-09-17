package com.example.reddot.reddittopviewer.ui.main

import com.arellomobile.mvp.InjectViewState
import com.example.reddot.reddittopviewer.tools.Constants.POST_LIMIT
import com.example.reddot.reddittopviewer.ui.adapter.PostAdapter
import com.example.reddot.reddittopviewer.ui.base.BasePresenter


@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    val adapter = PostAdapter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initAdapter(adapter)
    }

    fun loadFirstPosts() {
        addDisposables(
                repository.getTopPosts(POST_LIMIT)
                        .doOnRequest { showProgress() }
                        .subscribe({ response ->
                            adapter.setupList(response.data)
                        }, { t -> onError(t) },
                                { onCompleted() }
                        )
        )
    }

    fun loadMorePosts() {
        addDisposables(
                repository.getTopPostsPagination(POST_LIMIT, adapter.after)
                        .doOnRequest { showProgress() }
                        .subscribe({ response ->
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
        adapter.onError("Error")
        super.onError(throwable)
    }


}