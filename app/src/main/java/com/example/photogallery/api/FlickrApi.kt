package com.example.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "272fdca18b9dc2a797cf44b928e94d64"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )

    suspend fun fetchPhotos(): FlickrResponse
}