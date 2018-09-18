package com.example.reddot.reddittopviewer.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.reddot.reddittopviewer.R
import com.example.reddot.reddittopviewer.model.ClickItemModel
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Data
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.PostData
import com.example.reddot.reddittopviewer.tools.extensions.getTimeAgo
import com.jakewharton.rxbinding2.view.RxView
import inflate
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import loadUrl

class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), OnPagination<Data> {

    private val clickSubject = PublishSubject.create<ClickItemModel>()
    val clickEvent: Observable<ClickItemModel> = clickSubject

    private val itemsList: MutableList<PostModelAdapterItem> = mutableListOf()
    private var requestOptions: RequestOptions = RequestOptions()
    var after: String? = null

    init {
        requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    }

    override fun onProgress() {
        if (itemsList.isNotEmpty()) {
            checkLastItemType()
            itemsList.add(PostModelAdapterItem(type = PostModelAdapterItem.PROGRESS))
        }
    }

    override fun onComplete() {
        if (itemsList.isNotEmpty()) {
            val notPostModel = findNotPostDateItem()
            val index = itemsList.indexOf(notPostModel)
            itemsList.remove(notPostModel)
            if (index > 0)
                notifyItemRemoved(index)
        }
    }

    override fun onError(errorMessage: String) {
        checkLastItemType()
        itemsList.add(PostModelAdapterItem(PostModelAdapterItem.ERROR, errorMessage))
    }

    override fun skipList() {
        val count = itemsList.size
        after = null
        itemsList.clear()
        notifyItemRangeRemoved(0, count)
    }

    override fun setupList(newData: Data?) {
        itemsList.clear()
        after = newData?.after
        insertedItemRange(newData)
    }

    override fun updateList(newData: Data?) {
        after = newData?.after
        insertedItemRange(newData)
    }

    override fun getItemCount(): Int = itemsList.size

    override fun getItemViewType(position: Int): Int {
        return itemsList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PostModelAdapterItem.PROGRESS -> ProgressHolder(parent.inflate(R.layout.recycler_item_progress))
            PostModelAdapterItem.ERROR -> ErrorHolder(parent.inflate(R.layout.recycler_item_error))
            else -> PostHolder(parent.inflate(R.layout.recycler_item_post))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = itemsList[position]
        when (model.type) {
            PostModelAdapterItem.PROGRESS -> bindProgressView(holder as ProgressHolder, position)
            PostModelAdapterItem.ERROR -> bindErrorView(holder as ErrorHolder, position, model.error)
            else -> bindPostView(holder as PostHolder, position, model.post)
        }
    }

    private fun findNotPostDateItem(): PostModelAdapterItem? {
        var model: PostModelAdapterItem? = null
        itemsList.forEach { item ->
            if (item.type != PostModelAdapterItem.POST)
                model = item
        }
        return model
    }

    private fun checkLastItemType() {
        if (isLastItemNotPostData())
            removeLastItem()
    }


    private fun removeLastItem() {
        if (itemsList.size > 0) {
            val lastIndex = itemsList.lastIndex
            itemsList.removeAt(lastIndex)
            notifyItemRemoved(lastIndex)
        }
    }

    private fun insertedItemRange(newData: Data?) {
        newData?.let {
            val from = if (itemsList.size > 0) itemsList.size - 1 else 0
            val count = newData.children.size
            newData.children.forEach { children ->
                itemsList.add(PostModelAdapterItem(post = children.data))
            }
            notifyItemRangeInserted(from, count)
        }
    }

    private fun isLastItemNotPostData(): Boolean {
        return itemsList.size > 0 && itemsList[itemsList.lastIndex].type != PostModelAdapterItem.POST
    }

    private fun bindPostView(holder: PostHolder, position: Int, model: PostData?) {
        model?.let {
            holder.title.text = model.title
            holder.subReddit.text = model.subreddit
            holder.userName.text = model.author
            holder.score.text = getScore(model)
            holder.commentsCount.text = model.numComments.toString()
            holder.thumbnail.loadUrl(model.url, requestOptions)
            holder.time.text = model.createdUtc.getTimeAgo()
            rxViewClicks(position, model, holder.title, holder.thumbnail)
        }
    }

    private fun bindProgressView(holder: ProgressHolder, position: Int) {
        // do something
    }

    private fun bindErrorView(holder: ErrorHolder, position: Int, errorMessage: String) {
        if (errorMessage.isNotEmpty())
            holder.error.text = errorMessage
    }

    private fun getScore(model: PostData): String = "${model.ups / 1000}k"


    private fun rxViewClicks(position: Int, model: PostData, vararg views: View) {
        for (view in views) {
            RxView.clicks(view)
                    .map<ClickItemModel> { ClickItemModel(view.id, position, model) }
                    .subscribe (clickSubject)
        }
    }
}

