package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

class SourceModel {

    @SerializedName("id") val id: String? = null
    @SerializedName("name") val name: String? = ""
    @SerializedName("description") val description: String? = ""
    @SerializedName("url") val url: String? = ""
    @SerializedName("category") val category: String? = ""
    @SerializedName("language") val language: String? = ""
    @SerializedName("country") val country: String? = ""
}