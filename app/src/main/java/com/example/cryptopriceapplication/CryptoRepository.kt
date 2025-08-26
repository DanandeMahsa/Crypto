package com.example.cryptopriceapplication

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cryptopriceapplication.repository.network.CryptoApiService
import com.example.cryptopriceapplication.repository.network.db.CryptoDao
import com.example.cryptopriceapplication.repository.network.db.CryptoEntity

class CryptoRepository(private val dao : CryptoDao, private val api : CryptoApiService) {

    suspend fun fetchDataFromApi() {

        try {

            val response =
                api.getMarkets(currency = "usd")

            if (response.isSuccessful) {
                val body = response.body() ?: emptyList()

                val entities = body.map { crypto ->
                    CryptoEntity(
                        id = crypto.id,
                        name = crypto.name,
                        symbol = crypto.symbol,
                        image = crypto.image,
                        current_price = crypto.current_price,
                        price_change_percentage_24h = crypto.price_change_percentage_24h
                    )
                }
                dao.insertAll(entities)
            } else {
                Log.e("CryptoViewModel", "API Error: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("CryptoViewModel", "Exception: ${e.localizedMessage}")
        } finally {

        }

    }

    fun getAllCryptos() : LiveData<List<CryptoEntity>>{
        return  dao.getAllCryptos()
    }
}