package com.example.cryptopriceapplication.repository.network.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoList: List<CryptoEntity>)

    @Query("SELECT * FROM  crypto_table")
    fun getAllCryptos(): LiveData<List<CryptoEntity>>
}
