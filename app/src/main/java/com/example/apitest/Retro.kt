package com.example.apitest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {

    val retro = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}