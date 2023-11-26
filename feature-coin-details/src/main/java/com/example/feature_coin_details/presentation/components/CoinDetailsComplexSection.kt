package com.example.feature_coin_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.presentation.components.InfoCard
import com.example.core.presentation.components.InfoDivider

@Composable
internal fun CoinDetailsComplexSection(
    modifier: Modifier = Modifier,
    volume: String,
    marketCap: String,
    availableSupply: String,
    totalSupply: String,
    rank: String
) {
    InfoCard(
        modifier = modifier
    ) {
        CoinDataRow(value = rank, title = "Rank")
        InfoDivider()
        CoinDataRow(value = marketCap, title = "Market cap")
        InfoDivider()
        CoinDataRow(value = volume, title = "Volume")
        InfoDivider()
        CoinDataRow(value = availableSupply, title = "Available supply")
        InfoDivider()
        CoinDataRow(value = totalSupply, title = "Total supply")
    }
}

@Composable
internal fun CoinDataRow(
    value: String,
    title: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth().padding(8.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Text(
            text = value,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium
        )

    }
}