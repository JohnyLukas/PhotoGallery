package com.example.photogallery.repository

import com.example.photogallery.api.FlickrApi
import com.example.photogallery.api.GalleryItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class PhotoRepository @Inject constructor(private var flickrApi: FlickrApi) {

    suspend fun fetchPhotos(): List<GalleryItem> = flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhotos(query: String): List<GalleryItem> =
        flickrApi.searchPhotos(query).photos.galleryItems

}