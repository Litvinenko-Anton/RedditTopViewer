package com.example.reddot.reddittopviewer.model

import com.example.reddot.reddittopviewer.repository.remote.api.pojo.PostData

class ClickItemModel(id: Int, position: Int, val model: PostData) : ClickItem(id, position)
