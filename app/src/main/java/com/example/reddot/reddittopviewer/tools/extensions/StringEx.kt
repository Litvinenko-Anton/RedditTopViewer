package com.example.reddot.reddittopviewer.tools.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.ArticleModel
import java.util.*

fun sharedContent(context: Context, model: ArticleModel) {
    sharedContent(context, "Share ", "${model.title}\n${model.url}")
}

fun sharedContent(context: Context, subject: String, content: String) {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
    shareIntent.putExtra(Intent.EXTRA_TEXT, content)
    val intent = Intent.createChooser(shareIntent, "Share it")
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    context.startActivity(intent)
}

