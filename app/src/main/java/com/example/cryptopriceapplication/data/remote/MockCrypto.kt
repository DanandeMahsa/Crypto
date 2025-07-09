package com.example.cryptopriceapplication.data.remote

import com.example.cryptopriceapplication.model.CryptoEntity

object MockCrypto {
    val mockCryptoList = listOf(
        CryptoEntity(
            symbol = "BTC",
            priceUsd = "42500.78"
        ),
        CryptoEntity(
            symbol = "ETH",
            priceUsd = "2300.45"
        ),
        CryptoEntity(
            symbol = "BNB",
            priceUsd = "325.67"
        ),
        CryptoEntity(
            symbol = "XRP",
            priceUsd = "0.5678"
        ),
        CryptoEntity(
            symbol = "SOL",
            priceUsd = "102.34"
        ),
        CryptoEntity(
            symbol = "ADA",
            priceUsd = "0.3789"
        ),
        CryptoEntity(
            symbol = "DOGE",
            priceUsd = "0.0876"
        ),
        CryptoEntity(
            symbol = "DOT",
            priceUsd = "6.543"
        ),
        CryptoEntity(
            symbol = "AVAX",
            priceUsd = "35.21"
        ),
        CryptoEntity(
            symbol = "LINK",
            priceUsd = "15.67"
        )
    )

    fun getCrypto(): List<CryptoEntity> {
        return mockCryptoList
    }
}
//package com.example.cryptopriceapplication.data.remote
//
//import com.example.cryptopriceapplication.model.CryptoData
//import com.example.cryptopriceapplication.model.CryptoResponse
//
//object MockCrypto {
//
//    private val mockCryptoList = listOf(
//        CryptoData("BTC", "42500.78"),
//        CryptoData("ETH", "2300.45"),
//        CryptoData("BNB", "325.67"),
//        CryptoData("XRP", "0.5678"),
//        CryptoData("SOL", "102.34"),
//        CryptoData("ADA", "0.3789"),
//        CryptoData("DOGE", "0.0876"),
//        CryptoData("DOT", "6.543"),
//        CryptoData("AVAX", "35.21"),
//        CryptoData("LINK", "15.67")
//    )
//
//    fun getCryptoResponse(): CryptoResponse {
//        return CryptoResponse(data = mockCryptoList)
//    }
//}
