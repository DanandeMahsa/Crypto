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
package com.example.cryptopriceapplication.network

import com.example.cryptopriceapplication.model.Crypto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApiService {
    @GET("coins/markets")
    suspend fun getCryptoPrices(
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 50,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): Response<List<Crypto>>
}
