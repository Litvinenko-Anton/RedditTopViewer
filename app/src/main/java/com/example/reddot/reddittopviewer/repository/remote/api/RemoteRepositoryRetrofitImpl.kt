package com.example.reddot.reddittopviewer.repository.remote.api

import android.content.Context
import android.net.ConnectivityManager
import com.example.reddot.reddittopviewer.repository.remote.RemoteRepository
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RemoteRepositoryRetrofitImpl(private val appContext: Context, val api: RedditApi) : RemoteRepository {


    override fun getTopSt(limit: Int): Flowable<String> = getBaseRequestObservable(api.getTopSt(limit))

    override fun getTopPosts(limit: Int): Flowable<Top> = getBaseRequestObservable(api.getTop(limit))

    override fun getTopPostsPagination(limit: Int, after: String?): Flowable<Top> = getBaseRequestObservable(api.getTop(limit, after))

    private fun <T> getBaseRequestObservable(request: Flowable<T>): Flowable<T> {
        isOnline()
        return request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> throwable.printStackTrace() }
    }

    @SuppressWarnings("deprecation")
    private fun isOnline(): Boolean {
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetwork = cm?.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}