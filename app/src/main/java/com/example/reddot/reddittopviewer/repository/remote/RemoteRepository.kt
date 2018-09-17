package com.example.reddot.reddittopviewer.repository.remote

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top
import io.reactivex.Flowable


interface RemoteRepository  {

    fun getTopSt(limit: Int): Flowable<String>

    fun getTopPosts(limit: Int): Flowable<Top>

    fun getTopPostsPagination(limit: Int, after: String?): Flowable<Top>

}
