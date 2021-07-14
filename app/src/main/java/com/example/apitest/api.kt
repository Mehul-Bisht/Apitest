package com.example.apitest

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface api {

    @GET("v2/venues/search")
    suspend fun get(
        @Query("ll") longLat: String,
        @Query("client_id") id: String = Const.clientId,
        @Query("client_secret") secret: String = Const.clientSecret,
        @Query("v") date: String
    ): mainResponse
}