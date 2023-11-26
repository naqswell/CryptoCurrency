package com.example.feature_coin_details.domain.usecase

import com.example.feature_coin_details.domain.repository.CoinsTrackingRepository
import javax.inject.Inject

class IsCoinTrackingExistUseCase @Inject constructor(
    private val coinTrackingRepository: CoinsTrackingRepository,
) {
    suspend operator fun invoke(coinId: String): Boolean =
        coinTrackingRepository.isCoinTrackingExist(coinId)
}