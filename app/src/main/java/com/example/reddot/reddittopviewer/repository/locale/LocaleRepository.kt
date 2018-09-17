package com.example.reddot.reddittopviewer.repository.locale

interface LocaleRepository<R> {

    fun save(`object`: R)

    fun delete(`object`: R)

    fun deleteAll(objects: List<R>)

    fun contains(`object`: R): Boolean

    fun clear()

    fun destroy()

    fun addOnResultsChangeListener(listener: OnResultsChangeListener)

    fun removeOnResultsChangeListener(listener: OnResultsChangeListener)

    }