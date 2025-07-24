package com.example.cryptopriceapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptopriceapplication.db.CryptoDatabase
import com.example.cryptopriceapplication.model.Crypto
import com.example.cryptopriceapplication.model.CryptoEntity
import com.example.cryptopriceapplication.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoViewModel(application: Application) : AndroidViewModel(application),
    Callback<List<Crypto>> {
    val db = CryptoDatabase.getDatabase(application)
    private val _cryptoList = MutableLiveData<List<Crypto>>()
    val cryptoList: LiveData<List<Crypto>> = _cryptoList
    val cryptoListLive = db.cryptoDao().getAllCryptos()//next


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchDataFromApi()
    }

    fun fetchDataFromApi() {
        _isLoading.value = true
        // val response = RetrofitInstance.api.getMarkets2().enqueue(this)
        val response2 = RetrofitInstance.api.getMarkets2().enqueue(object : Callback<List<Crypto>> {
            override fun onResponse(
                call: Call<List<Crypto>?>,
                response: Response<List<Crypto>?>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()?:return
                    _cryptoList.postValue(body)
                    db.cryptoDao().insertAll(body.map { crypt-> CryptoEntity(crypt.name,
                        0.toString()
                    )})
                } else {
                    Log.e("CryptoViewModel", "API Error: ${response.message()}")
                }
                _isLoading.value = false
            }

            override fun onFailure(
                call: Call<List<Crypto>?>,
                t: Throwable
            ) {
                Log.e("CryptoViewModel", "Network Exception: ${t.message}")
                _isLoading.value = false
            }
        })
    }

    override fun onResponse(
        call: Call<List<Crypto>>,
        response: Response<List<Crypto>>
    ) {
        TODO("Not yet implemented")
    }

    override fun onFailure(
        call: Call<List<Crypto>>,
        t: Throwable
    ) {
        TODO("Not yet implemented")
    }
}