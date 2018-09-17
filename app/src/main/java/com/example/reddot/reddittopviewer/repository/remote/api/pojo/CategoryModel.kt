package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.BaseModel
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.SourceModel
import com.google.gson.annotations.SerializedName

class CategoryModel : BaseModel() {

    @SerializedName("sources") val sources: List<SourceModel> = ArrayList()

}