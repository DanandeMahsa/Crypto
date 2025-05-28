package com.example.cryptopriceapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class CryptoEntity(
    @PrimaryKey val symbol: String,
    val priceUsd: String
)
