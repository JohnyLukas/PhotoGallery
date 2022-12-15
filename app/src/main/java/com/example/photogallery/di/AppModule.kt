package com.example.photogallery.di

import com.example.photogallery.api.FlickrApi
import com.example.photogallery.api.PhotoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://api.flickr.com/"

    private val okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(): FlickrApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FlickrApi::class.java)

}