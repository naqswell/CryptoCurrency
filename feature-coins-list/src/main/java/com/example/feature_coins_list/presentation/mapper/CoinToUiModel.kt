package com.example.feature_coins_list.presentation.mapper

import com.example.feature_coins_list.domain.model.Coin
import com.example.feature_coins_list.presentation.model.CoinDisplayable

fun Coin.toPresentationModel() = CoinDisplayable(
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

fun List<Coin>.toPresentationModel(): List<CoinDisplayable> {
    val coins = mutableListOf<CoinDisplayable>()

    forEach { item ->
        coins.add(item.toPresentationModel())
    }

    return coins
}