package com.example.reddot.reddittopviewer.di

import android.annotation.SuppressLint
import android.content.Context
import com.example.reddot.reddittopviewer.App
import com.example.reddot.reddittopviewer.BuildConfig
import com.example.reddot.reddittopviewer.repository.RepositoryImp
import com.example.reddot.reddittopviewer.repository.locale.LocaleRepository
import com.example.reddot.reddittopviewer.repository.remote.RemoteRepository
import com.example.reddot.reddittopviewer.repository.remote.api.RedditApi
import com.example.reddot.reddittopviewer.repository.remote.api.RemoteRepositoryRetrofitImpl
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top
import com.example.reddot.reddittopviewer.tools.Constants.BASE_URL
import com.example.reddot.reddittopviewer.tools.Constants.OK_HTTP_CLIENT_TIMEOUT
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@SuppressLint("StaticFieldLeak")
object ApiModules {

    private val appContext: Context

    init {
        appContext = App.appContext
    }

    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        builder.connectTimeout((OK_HTTP_CLIENT_TIMEOUT * 1000).toLong(), TimeUnit.MILLISECONDS)
                .readTimeout((OK_HTTP_CLIENT_TIMEOUT * 1000).toLong(), TimeUnit.MILLISECONDS)

        return builder.build()
    }

    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder
                .setLenient()
                .create()
    }

    fun provideRestAdapter(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
        return builder.build()
    }

    fun provideApiService(restAdapter: Retrofit): RedditApi {
        return restAdapter.create(RedditApi::class.java)
    }

    fun provideRemoteRepository(apiService: RedditApi): RemoteRepository {
        return RemoteRepositoryRetrofitImpl(appContext, apiService)
    }

    fun provideRepository(remoteRepository: RemoteRepository, localeRepository: LocaleRepository<Top>): RepositoryImp {
        return RepositoryImp(remoteRepository, localeRepository)
    }

}