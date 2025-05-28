package com.example.cryptopriceapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptopriceapplication.data.remote.MockCrypto
import com.example.cryptopriceapplication.db.CryptoDatabase
import com.example.cryptopriceapplication.model.CryptoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CryptoViewModel() : ViewModel() {
    //private val db: CryptoDatabase
    private val _cryptoList = MutableLiveData<List<CryptoEntity>>()
    val cryptoList: LiveData<List<CryptoEntity>> get() = _cryptoList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun loadFromDatabase() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val cryptos = withContext(Dispatchers.IO) {
                   // db.cryptoDao().getAllCryptos()
                }
              //  _cryptoList.value = cryptos
            } catch (e: Exception) {
                _errorMessage.value = "خطا در بارگیری از دیتابیس: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updateFromApi() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val cryptos = MockCrypto.getCrypto()
                _cryptoList.value = cryptos
                withContext(Dispatchers.IO) {
                    //db.cryptoDao().insertAll(cryptos)
                }
            } catch (e: Exception) {
                _errorMessage.value = "خطا در دریافت داده از API: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}