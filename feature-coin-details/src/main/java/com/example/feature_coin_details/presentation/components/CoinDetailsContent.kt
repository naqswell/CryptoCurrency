package com.example.feature_coin_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.utils.numbersToCurrency
import com.example.core.utils.numbersToFormat
import com.example.feature_coin_details.presentation.model.CoinDetailsDisplayable

@Composable
internal fun CoinDetailsContent(
    coin: CoinDetailsDisplayable,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CoinDetailSection(
            price = coin.price,
            priceChange = coin.priceChange1d
        )
        CoinDetailsComplexSection(
            rank = "${coin.rank}",
            volume = numbersToCurrency(coin.volume.toInt()),
            marketCap = numbersToCurrency(coin.marketCap.toInt()),
            availableSupply = "${numbersToFormat(coin.availableSupply.toInt())} ${coin.symbol}",
            totalSupply = "${numbersToFormat(coin.totalSupply.toInt())} ${coin.symbol}"
        )
    }
}