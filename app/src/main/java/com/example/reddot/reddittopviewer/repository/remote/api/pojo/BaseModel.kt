package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName

open class BaseModel {

    @SerializedName("status") val status: String? = ""
    @SerializedName("code") val code: String? = ""
    @SerializedName("message") val message: String? = ""

    fun isSuccess(): Boolean = status != null && status == "ok"

}