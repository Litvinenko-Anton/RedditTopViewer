package com.example.reddot.reddittopviewer.di

import com.example.reddot.reddittopviewer.repository.RepositoryImp

class InjectHelper {

    val repository: RepositoryImp

    init {
        val okHttpClient = ApiModules.provideOkHttpClient()
        val gson = ApiModules.provideGson()
        val retrofit = ApiModules.provideRestAdapter(gson, okHttpClient)
        val api = ApiModules.provideApiService(retrofit)
        val remoteRepository = ApiModules.provideRemoteRepository(api)
        val localeRepository = DbModules.provideLocaleRepository()
        repository = ApiModules.provideRepository(remoteRepository, localeRepository)
    }

}