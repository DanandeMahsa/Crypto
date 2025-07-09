package com.example.cryptopriceapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory // یا هر Converter دیگری که استفاده می‌کنی

object RetrofitInstance {
    private const val BASE_URL = "https://api.coinpaprika.com/"

    val api: CryptoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApiService::class.java)
    }
}