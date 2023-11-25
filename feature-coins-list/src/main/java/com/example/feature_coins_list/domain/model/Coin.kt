package com.example.feature_coins_list.domain.model

data class Coin(
    val availableSupply: Double,
    val contractAddress: String,
    val decimals: Int,
    val exp: List<String>,
    val icon: String,
    val id: String,
    val marketCap: Double,
    val name: String,
    val price: Double,
    val priceBtc: Double,
    val priceChanged1d: Double,
    val priceChanged1h: Double,
    val priceChanged1w: Double,
    val rank: Int,
    val redditUrl: String,
    val symbol: String,
    val totalSupply: Double,
    val twitterUrl: String,
    val volume: Double,
    val websiteUrl: String
)