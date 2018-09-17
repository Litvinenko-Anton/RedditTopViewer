package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.SourceModel
import com.google.gson.annotations.SerializedName

class ArticleModel {

    var favorites: Boolean = false

    @SerializedName("source") val source: SourceModel? = SourceModel()
    @SerializedName("author") val author: String? = ""
    @SerializedName("title") val title: String? = ""
    @SerializedName("description") val description: String? = ""
    @SerializedName("url") val url: String? = ""
    @SerializedName("urlToImage") val urlToImage: String? = ""
    @SerializedName("publishedAt") val publishedAt: String? = ""

}