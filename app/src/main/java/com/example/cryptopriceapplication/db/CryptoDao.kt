package com.example.cryptopriceapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cryptopriceapplication.model.CryptoEntity

@Dao
interface CryptoDao {
    @Query("SELECT * FROM crypto_table")
    fun getAllCryptos(): List<CryptoEntity>

    @Query("SELECT * FROM crypto_table")
    fun getAllCryptosLive(): LiveData<List<CryptoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(cryptos: List<CryptoEntity>)
     @Delete
     fun deleteAll(cryptos: List<CryptoEntity>)
     @Update
     fun updateCrypto(cryptos: List<CryptoEntity>)
     @Delete
     fun deleteCtypto(crypto: CryptoEntity)
}
