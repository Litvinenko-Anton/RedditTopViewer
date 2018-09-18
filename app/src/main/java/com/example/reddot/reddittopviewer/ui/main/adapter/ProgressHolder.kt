package com.example.reddot.reddittopviewer.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.recycler_item_progress.view.*

class ProgressHolder(view: View) : RecyclerView.ViewHolder(view) {

    var progress: ProgressBar = view.progress_bar

}