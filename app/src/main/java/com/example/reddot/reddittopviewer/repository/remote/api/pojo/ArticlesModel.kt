package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.ArticleModel
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.BaseModel
import com.google.gson.annotations.SerializedName
import java.util.*

class ArticlesModel : BaseModel() {

    @SerializedName("totalResults")  val totalResults: Int = 0
    @SerializedName("articles")  val articles = ArrayList<ArticleModel>()

}