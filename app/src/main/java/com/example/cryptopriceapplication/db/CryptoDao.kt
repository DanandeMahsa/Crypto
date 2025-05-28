package com.example.cryptopriceapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptopriceapplication.model.CryptoEntity

@Dao
interface CryptoDao {
    @Query("SELECT * FROM crypto_table")
    suspend fun getAllCryptos(): List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptos: List<CryptoEntity>)
}
