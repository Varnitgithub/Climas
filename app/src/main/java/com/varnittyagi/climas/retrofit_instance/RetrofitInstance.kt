package com.varnittyagi.climas.retrofit_instance

import com.varnittyagi.climas.api_interface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.currentsapi.services/v1/").addConverterFactory(
            GsonConverterFactory.create())
            .build()
    }

    val apiInterfaceInstance: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}