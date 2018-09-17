package com.example.reddot.reddittopviewer.ui.adapter

interface OnPagination<T> {

    fun onProgress()

    fun onComplete()

    fun onError(errorMessage: String)

    fun skipList()

    fun setupList(newData: T?)

    fun updateList(newData: T?)

}