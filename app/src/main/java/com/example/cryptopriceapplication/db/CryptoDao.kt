package com.example.cryptopriceapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptopriceapplication.model.CryptoEntity

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoList: List<CryptoEntity>)

    @Query("SELECT * FROM  crypto_table")
    fun getAllCryptos(): LiveData<List<CryptoEntity>>
}
