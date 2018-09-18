package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class Gif(
        @SerializedName("source") val source: Source,
        @SerializedName("resolutions") val resolutions: List<Resolution>
)