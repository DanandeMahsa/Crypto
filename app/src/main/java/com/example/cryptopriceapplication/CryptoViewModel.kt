package com.example.cryptopriceapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptopriceapplication.model.Crypto
import com.example.cryptopriceapplication.network.RetrofitInstance
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {


    private val _cryptoList = MutableLiveData<List<Crypto>>()
    val cryptoList: LiveData<List<Crypto>> = _cryptoList


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun fetchDataFromApi() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getMarkets()

                if (response.isSuccessful) {
                    _cryptoList.postValue(response.body())
                } else {
                    Log.e("CryptoViewModel", "API Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("CryptoViewModel", "Network Exception: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}