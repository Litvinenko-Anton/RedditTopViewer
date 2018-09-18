package com.example.reddot.reddittopviewer.repository

import com.example.reddot.reddittopviewer.repository.locale.LocaleRepository
import com.example.reddot.reddittopviewer.repository.locale.OnResultsChangeListener
import com.example.reddot.reddittopviewer.repository.remote.RemoteRepository
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top
import io.reactivex.Flowable


class RepositoryImp(private val remoteRepository: RemoteRepository,
                    private val localeRepository: LocaleRepository<Top>) : Repository {

    /**
     * REMOTE
     * */

    /**
     * First page
     * @param limit - page size
     * @return - flowable
     */
    override fun getTopPosts(limit: Int): Flowable<Top> = remoteRepository.getTopPosts(limit)

    /**
     * Next page(pagination)
     * @param limit - page size
     * @param after - from previous response
     * @return - flowable
     */
    override fun getTopPostsPagination(limit: Int, after: String?): Flowable<Top> = remoteRepository.getTopPostsPagination(limit, after)


    /**
     * LOCAL
     * */

    override fun save(`object`: Top)  = localeRepository.save(`object`)

    override fun delete(`object`: Top) = localeRepository.delete(`object`)

    override fun deleteAll(objects: List<Top>) = localeRepository.deleteAll(objects)

    override fun contains(`object`: Top): Boolean = localeRepository.contains(`object`)

    override fun clear() = localeRepository.clear()

    override fun destroy() = localeRepository.destroy()

    override fun addOnResultsChangeListener(listener: OnResultsChangeListener)
            = localeRepository.addOnResultsChangeListener(listener)

    override fun removeOnResultsChangeListener(listener: OnResultsChangeListener)
            = localeRepository.removeOnResultsChangeListener(listener)

}
