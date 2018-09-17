package com.example.reddot.reddittopviewer.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.recycler_item_post.view.*

class PostHolder(view: View) : RecyclerView.ViewHolder(view) {

    var subReddit: TextView = view.tv_subreddit
    var userName: TextView = view.tv_user
    var title: TextView = view.tv_title
    var time: TextView = view.tv_time
    var score: TextView = view.tv_likes_count
    var commentsCount: TextView = view.tv_comments_count
    var thumbnail: ImageView = view.iv_thumb

}