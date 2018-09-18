package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class Preview(
        @SerializedName("images") val images: List<Image>?,
        @SerializedName("reddit_video_preview") val redditVideoPreview: RedditVideoPreview,
        @SerializedName("enabled") val enabled: Boolean
)