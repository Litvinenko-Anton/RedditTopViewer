package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class RedditVideoPreview(
        @SerializedName("fallback_url") val fallbackUrl: String?,
        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("scrubber_media_url") val scrubberMediaUrl: String?,
        @SerializedName("dash_url") val dashUrl: String?,
        @SerializedName("duration") val duration: Int,
        @SerializedName("hls_url") val hlsUrl: String?,
        @SerializedName("is_gif") val isGif: Boolean,
        @SerializedName("transcoding_status") val transcodingStatus: String?
)