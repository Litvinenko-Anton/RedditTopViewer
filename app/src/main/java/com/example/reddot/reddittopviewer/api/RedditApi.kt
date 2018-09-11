package com.example.reddot.reddittopviewer.api

import com.example.reddot.reddittopviewer.model.pojo.Top
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface RedditApi {

    @GET("top.json")
    fun getTop(@Query("limit") limit: Int, @Query("after") after: String): Observable<Top>

}