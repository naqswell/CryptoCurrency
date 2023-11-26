package com.example.feature_coin_details.data.mapper

import com.example.cache_coins.model.CoinTrackingCached
import com.example.core.utils.getCurrentDate
import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.network_coinstats.model.CoinResponse

fun CoinResponse.toDomainModel() = CoinDetails(
    availableSupply = availableSupply,
    contractAddress = contractAddress,
    decimals = decimals,
    exp = exp,
    icon = icon,
    id = id,
    marketCap = marketCap,
    name = name,
    price = price,
    priceBtc = priceBtc,
    priceChanged1d = priceChange1d,
    priceChanged1h = priceChange1h,
    priceChanged1w = priceChange1w,
    rank = rank,
    redditUrl = redditUrl,
    symbol = symbol,
    totalSupply = totalSupply,
    twitterUrl = twitterUrl,
    volume = volume,
    websiteUrl = websiteUrl
)

fun List<CoinResponse>.toDomainModel(): List<CoinDetails> {
    val coins = mutableListOf<CoinDetails>()
    forEach { item ->
        coins.add(item.toDomainModel())
    }
    return coins
}

fun CoinDetails.toEntityModel() = CoinTrackingCached(
    coinId = id,
    name = name,
    symbol = symbol,
    icon = icon,
    price = price,
    rank = rank,
    priceChanged1d = priceChanged1d,
    priceChanged1h = priceChanged1h,
    priceChanged1w = priceChanged1w,
    lastUpdated = getCurrentDate()
)