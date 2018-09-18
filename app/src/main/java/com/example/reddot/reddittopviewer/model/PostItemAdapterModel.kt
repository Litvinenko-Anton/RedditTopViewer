package com.example.reddot.reddittopviewer.model

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.PostData

class PostItemAdapterModel(
        val type: Int = POST,
        val error: String = "",
        val post: PostData? = null) {

    companion object {
        const val POST: Int = 1
        const val PROGRESS: Int = 2
        const val ERROR: Int = 3
    }

}