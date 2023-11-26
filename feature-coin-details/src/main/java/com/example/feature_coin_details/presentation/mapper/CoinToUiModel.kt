package com.example.feature_coin_details.presentation.mapper

import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.feature_coin_details.presentation.model.CoinDetailsDisplayable

fun CoinDetails.toPresentationModel() = CoinDetailsDisplayable(
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
    priceChange1d = priceChanged1d,
    priceChange1h = priceChanged1h,
    priceChange1w = priceChanged1w,
    rank = rank,
    redditUrl = redditUrl,
    symbol = symbol,
    totalSupply = totalSupply,
    twitterUrl = twitterUrl,
    volume = volume,
    websiteUrl = websiteUrl
)

fun List<CoinDetails>.toPresentationModel(): List<CoinDetailsDisplayable> {
    val coins = mutableListOf<CoinDetailsDisplayable>()

    forEach { item ->
        coins.add(item.toPresentationModel())
    }

    return coins
}