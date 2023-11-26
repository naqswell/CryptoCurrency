package com.example.feature_coins_tracking_list.presentation.mapper

import com.example.feature_coins_tracking_list.domain.model.CoinTracking
import com.example.feature_coins_tracking_list.presentation.model.CoinTrackingDisplayable

fun CoinTracking.toPresentationModel() = CoinTrackingDisplayable(
    coinId = coinId,
    name = name,
    symbol = symbol,
    icon = icon,
    price = price,
    rank = rank,
    priceChanged1d = priceChanged1d,
    priceChanged1h = priceChanged1h,
    priceChanged1w = priceChanged1w,
    lastUpdated = lastUpdated
)