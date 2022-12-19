package com.example.photogallery.di

import com.example.photogallery.BuildConfig
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
    private val okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(): FlickrApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FlickrApi::class.java)

}