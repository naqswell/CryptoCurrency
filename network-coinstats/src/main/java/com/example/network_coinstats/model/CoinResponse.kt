package com.example.network_coinstats.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponse(
    @SerialName("availableSupply") val availableSupply: Double = 0.0,
    @SerialName("contractAddress") val contractAddress: String = "",
    @SerialName("decimals") val decimals: Int = 0,
    @SerialName("exp") val exp: List<String> = emptyList(),
    @SerialName("icon") val icon: String = "",
    @SerialName("id") val id: String = "",
    @SerialName("marketCap") val marketCap: Double = 0.0,
    @SerialName("name") val name: String = "",
    @SerialName("price") val price: Double = 0.0,
    @SerialName("priceBtc") val priceBtc: Double = 0.0,
    @SerialName("priceChange1d") val priceChange1d: Double = 0.0,
    @SerialName("priceChange1h") val priceChange1h: Double = 0.0,
    @SerialName("priceChange1w") val priceChange1w: Double = 0.0,
    @SerialName("rank") val rank: Int = 0,
    @SerialName("redditUrl") val redditUrl: String = "",
    @SerialName("symbol") val symbol: String = "",
    @SerialName("totalSupply") val totalSupply: Double = 0.0,
    @SerialName("twitterUrl") val twitterUrl: String = "",
    @SerialName("volume") val volume: Double = 0.0,
    @SerialName("websiteUrl") val websiteUrl: String = ""
)