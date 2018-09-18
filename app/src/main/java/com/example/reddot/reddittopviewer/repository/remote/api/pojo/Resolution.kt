package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class Resolution(
        @SerializedName("url") val url: String?,
        @SerializedName("width") val width: Int,
        @SerializedName("height") val height: Int
)