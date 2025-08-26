package com.example.cryptopriceapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptopriceapplication.repository.network.db.CryptoDatabase

class CryptoViewModelFactory(private val db: CryptoDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CryptoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
//            return CryptoViewModel() as T
        TODO()
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}