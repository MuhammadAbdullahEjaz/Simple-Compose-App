package com.example.gamestore.di

import com.example.gamestore.data.remote.GameStoreService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
object GameStoreModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(3,TimeUnit.MINUTES)
        okHttpClientBuilder.readTimeout(3, TimeUnit.MINUTES)
        okHttpClientBuilder.writeTimeout(3, TimeUnit.MINUTES)
        return okHttpClientBuilder.build()
    }


    @Provides
    fun provideGameStoreService(OkHttpClient:OkHttpClient): GameStoreService {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(OkHttpClient)
            .baseUrl("https://rawg-video-games-database.p.rapidapi.com")
            .build()
            .create(GameStoreService::class.java)
    }
}