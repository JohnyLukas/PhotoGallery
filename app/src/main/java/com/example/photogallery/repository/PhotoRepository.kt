package com.example.photogallery.repository

import com.example.photogallery.api.FlickrApi
import com.example.photogallery.api.GalleryItem
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val flickrApi: FlickrApi,
    private val preferencesRepository: PreferencesRepository
) {

    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhotos(query: String): List<GalleryItem> =
        flickrApi.searchPhotos(query).photos.galleryItems

}