package com.example.soosoocloset

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: RetrofitApi = initApi()

    private fun initApi(): RetrofitApi =
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000") // localhost
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
}