package com.example.network_coinstats.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinsListResponse(
    @SerialName("result") val result: List<CoinResponse> = emptyList(),
)