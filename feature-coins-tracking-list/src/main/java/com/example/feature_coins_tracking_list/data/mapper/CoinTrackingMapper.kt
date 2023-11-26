package com.example.feature_coins_tracking_list.data.mapper

import com.example.cache_coins.model.CoinTrackingCached
import com.example.feature_coins_tracking_list.domain.model.CoinTracking

fun CoinTrackingCached.toDomainModel() = CoinTracking(
    coinId = coinId,
    name = name,
    symbol = symbol,
    icon = icon,
    price = price,
    rank = rank,
    priceChanged1d = priceChanged1d,
    priceChanged1h = priceChanged1d,
    priceChanged1w = priceChanged1w,
    lastUpdated = lastUpdated
)

fun CoinTracking.toEntityModel() = CoinTrackingCached(
    coinId = coinId,
    name = name,
    symbol = symbol,
    icon = icon,
    price = price,
    rank = rank,
    priceChanged1d = priceChanged1d,
    priceChanged1h = priceChanged1d,
    priceChanged1w = priceChanged1w,
    lastUpdated = lastUpdated
)