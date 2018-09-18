package com.example.reddot.reddittopviewer.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.recycler_item_error.view.*

class ErrorHolder(view: View) : RecyclerView.ViewHolder(view) {

    var error: TextView = view.tv_error_text
    var tryAgain: Button = view.btn_try_again

}