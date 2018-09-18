package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class SecureMediaEmbed(
        @SerializedName("content") val content: String?,
        @SerializedName("width") val width: Int,
        @SerializedName("scrolling") val scrolling: Boolean,
        @SerializedName("media_domain_url") val mediaDomainUrl: String?,
        @SerializedName("height") val height: Int
)