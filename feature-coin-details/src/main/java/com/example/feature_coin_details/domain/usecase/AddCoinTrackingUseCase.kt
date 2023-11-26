package com.example.feature_coin_details.domain.usecase

import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.feature_coin_details.domain.repository.CoinsTrackingRepository
import javax.inject.Inject

class AddCoinTrackingUseCase @Inject constructor(
    private val coinsTrackingRepository: CoinsTrackingRepository
) {
    suspend operator fun invoke(coin: CoinDetails) {
        coinsTrackingRepository.upsertCoinTracking(coin)
    }
}