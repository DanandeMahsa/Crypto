package com.example.cryptopriceapplication.model

data class CryptoResponse(
    val data: List<CryptoData>
)

data class CryptoData(
    val symbol: String,
    val priceUsd: String
)

// تبدیل لیست CryptoData به CryptoEntity
fun List<CryptoData>.toEntityList(): List<CryptoEntity> {
    return map { CryptoEntity(it.symbol, it.priceUsd) }
}