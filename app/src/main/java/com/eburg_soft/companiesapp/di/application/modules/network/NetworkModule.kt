package com.eburg_soft.companiesapp.di.application.modules.network

import com.eburg_soft.companiesapp.di.application.scope.AppScope
import com.eburg_soft.companiesapp.model.ApiClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

@Module
class NetworkModule {

    private val BASE_URL = "http://megakohz.bget.ru"
    private val MAX_READ_TIMEOUT: Long = 5
    private val MAX_CONNECT_TIMEOUT: Long = 5

    @Provides
    @AppScope
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Provides
    @AppScope
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(MAX_CONNECT_TIMEOUT, SECONDS)
            .readTimeout(MAX_READ_TIMEOUT, SECONDS)
            .build()

    @Provides
    @AppScope
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @AppScope
    fun provideApiService(retrofit: Retrofit): ApiClient =
        retrofit.create(ApiClient::class.java)
}