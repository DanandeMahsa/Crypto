//package com.example.cryptopriceapplication.network
//
//import com.example.cryptopriceapplication.model.CryptoResponse
//import retrofit2.Response
//import retrofit2.http.GET
//
//interface CryptoApiService {
//    @GET("assets")
//    suspend fun getCryptos(): Response<CryptoResponse>
//}
package com.example.cryptopriceapplication.repository.network

import com.example.cryptopriceapplication.model.Crypto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BallanceApiService {
    @GET("v1/coins")
    suspend fun getMarkets(
        @Query("vs_currency") currency: String = "usd" // دریافت قیمت بر اساس دلار
    ): Response<List<Crypto>>
}
