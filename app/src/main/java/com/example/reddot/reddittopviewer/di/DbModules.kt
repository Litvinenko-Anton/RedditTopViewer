package com.example.reddot.reddittopviewer.di

import com.example.reddot.reddittopviewer.repository.locale.LocaleRepository
import com.example.reddot.reddittopviewer.repository.locale.LocaleRepositoryImp
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top

object DbModules {

    fun provideLocaleRepository(): LocaleRepository<Top> {
        return LocaleRepositoryImp()
    }

}