package com.example.cryptopriceapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class CryptoEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
    var image:  String?,
    val current_price: Double,
    val price_change_percentage_24h: Double
)
