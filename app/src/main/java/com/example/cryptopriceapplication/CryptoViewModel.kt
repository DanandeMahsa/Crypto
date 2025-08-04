package com.example.cryptopriceapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptopriceapplication.db.CryptoDatabase
import com.example.cryptopriceapplication.model.Crypto
import com.example.cryptopriceapplication.model.CryptoEntity
import com.example.cryptopriceapplication.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CryptoViewModel(application: Application) : AndroidViewModel(application) {
    private val db = CryptoDatabase.getDatabase(application)
    val cryptoListLive: LiveData<List<CryptoEntity>> = db.cryptoDao().getAllCryptos()

    private val _cryptoList = MutableLiveData<List<Crypto>>()
    val cryptoList: LiveData<List<Crypto>> = _cryptoList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchDataFromApi()
    }

    fun fetchDataFromApi() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getMarkets(currency = "usd")
                }

                if (response.isSuccessful) {
                    val body = response.body() ?: emptyList()
                    _cryptoList.value = body

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

                    withContext(Dispatchers.IO) {
                        db.cryptoDao().insertAll(entities)
                    }
                } else {
                    Log.e("CryptoViewModel", "API Error: ${response.message()}")
                }

            } catch (e: Exception) {
                Log.e("CryptoViewModel", "Exception: ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}
