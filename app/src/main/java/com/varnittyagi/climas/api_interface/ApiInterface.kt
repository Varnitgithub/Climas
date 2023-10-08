package com.varnittyagi.climas.api_interface

import com.varnittyagi.climas.model_classes.gnews_model.CurrentNewsModel
import com.varnittyagi.climas.model_classes.gnews_model.LatestNewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
const val API_KEY = "x2tW7amoC5UPrNp3fydxkY9AyUlKdI8sgXhlgQ6oCbHbaQR2"


interface ApiInterface {



    @GET("latest-news")
    fun latestNews(@Query("language") language: String,@Header("Authorization") apiKey: String ):Call<LatestNewsModel>

    @GET("search")
    fun getCurrentData(@Query("keywords") keywords: String,
                       @Query("language") language: String,
                              @Header("Authorization") apiKey: String):Call<CurrentNewsModel>
}