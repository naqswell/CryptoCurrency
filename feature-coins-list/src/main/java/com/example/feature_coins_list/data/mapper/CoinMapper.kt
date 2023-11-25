package com.example.feature_coins_list.data.mapper

import com.example.feature_coins_list.domain.model.Coin
import com.example.network_coinstats.model.CoinResponse

internal fun CoinResponse.toDomainModelCoin() = Coin(
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

internal fun List<CoinResponse>.toDomainModelCoin(): List<Coin> {
    val coins = mutableListOf<Coin>()
    forEach { item ->
        coins.add(item.toDomainModelCoin())
    }
    return coins
}