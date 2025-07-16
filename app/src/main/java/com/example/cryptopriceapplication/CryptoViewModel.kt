package com.example.cryptopriceapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptopriceapplication.model.Crypto
import com.example.cryptopriceapplication.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoViewModel : ViewModel(), Callback<List<Crypto>> {


    private val _cryptoList = MutableLiveData<List<Crypto>>()
    val cryptoList: LiveData<List<Crypto>> = _cryptoList


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun fetchDataFromApi() {
        _isLoading.value = true
           // val response = RetrofitInstance.api.getMarkets2().enqueue(this)
            val response2 = RetrofitInstance.api.getMarkets2().enqueue(object : Callback<List<Crypto>>{
                override fun onResponse(
                    call: Call<List<Crypto>?>,
                    response: Response<List<Crypto>?>
                ) {
                    if (response.isSuccessful) {
                        _cryptoList.postValue(response.body())
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