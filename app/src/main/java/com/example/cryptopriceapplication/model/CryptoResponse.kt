package com.example.cryptopriceapplication.model

data class CryptoResponse(
    val data: List<CryptoData>
)

data class CryptoData(
    val symbol: String,
    val priceUsd: String
)

fun List<CryptoData>.toEntityList(): List<CryptoEntity> {
    return map {
        CryptoEntity(
            id = it.symbol,
            name = it.symbol,
            symbol = it.symbol,
            image = "",
            current_price = it.priceUsd.toDoubleOrNull() ?: 0.0,
            price_change_percentage_24h = 0.0
        )
    }
}
