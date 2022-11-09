package com.example.fcm.api

import com.example.fcm.BuildConfig
import com.example.fcm.data.remote.response.ShoppingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


open interface ShoppingAPI {
    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey :String = BuildConfig.API_KEY
    ) : Response<ShoppingResponse >
}