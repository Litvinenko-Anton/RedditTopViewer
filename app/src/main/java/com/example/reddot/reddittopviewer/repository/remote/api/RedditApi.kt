package com.example.reddot.reddittopviewer.repository.remote.api

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Base URL: https://www.reddit.com/
 */

interface RedditApi {

    @GET("top.json")
    fun getTop(
            @Query("limit") limit: Int,
            @Query("after") after: String? = null
    ): Flowable<Top>

}