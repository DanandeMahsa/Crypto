package com.example.cryptopriceapplication.repository.network

import com.example.cryptopriceapplication.model.Crypto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApiService {
    @GET("v1/coins")
    suspend fun getMarkets(
        @Query("vs_currency") currency: String = "usd"
    ): Response<List<Crypto>>
}
