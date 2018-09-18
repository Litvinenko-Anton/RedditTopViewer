package com.example.reddot.reddittopviewer.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.recycler_item_post.view.*

class PostHolder(view: View) : RecyclerView.ViewHolder(view) {

    var title: TextView = view.tv_title
    var thumbnail: ImageView = view.iv_thumb
    var score: TextView = view.tv_likes_count
    var commentsCount: TextView = view.tv_comments_count
    var subReddit: TextView = view.tv_subreddit
    var userName: TextView = view.tv_user
    var time: TextView = view.tv_time
    var likes: ImageButton = view.ib_likes
    var dislikes: ImageButton = view.ib_dislikes
    var share: ImageButton = view.ib_share
    var browser: ImageButton = view.ib_browser

}