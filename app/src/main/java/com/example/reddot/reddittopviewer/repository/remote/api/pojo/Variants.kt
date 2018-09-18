package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class Variants(
        @SerializedName("gif") val gif: Gif,
        @SerializedName("mp4") val mp4: Mp4
)