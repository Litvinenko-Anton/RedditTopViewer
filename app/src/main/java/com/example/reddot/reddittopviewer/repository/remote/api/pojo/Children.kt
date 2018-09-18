package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class Children(
        @SerializedName("kind") val kind: String?,
        @SerializedName("data") val data: PostData
)