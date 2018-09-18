package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

data class Image(
        @SerializedName("source") val source: Source,
        @SerializedName("resolutions") val resolutions: List<Resolution>?,
        @SerializedName("variants") val variants: Variants,
        @SerializedName("id") val id: String?
)