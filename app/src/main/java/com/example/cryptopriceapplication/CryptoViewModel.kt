package com.example.cryptopriceapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptopriceapplication.repository.network.RetrofitInstance
import com.example.cryptopriceapplication.repository.network.db.CryptoDatabase
import com.example.cryptopriceapplication.repository.network.db.CryptoEntity
import kotlinx.coroutines.launch

class CryptoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CryptoRepository = CryptoRepository(
        dao = CryptoDatabase.getDatabase(application).cryptoDao(),
        api = RetrofitInstance.api
    )
    val cryptoListLive: LiveData<List<CryptoEntity>> = repository.getAllCryptos()


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {

        viewModelScope.launch {
            _isLoading.postValue(true)
            repository.fetchDataFromApi()
            _isLoading.postValue(false)
        }
    }
}
