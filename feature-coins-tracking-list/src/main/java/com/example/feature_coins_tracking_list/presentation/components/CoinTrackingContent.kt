package com.example.feature_coins_tracking_list.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.presentation.components.BasicCard
import com.example.feature_coins_tracking_list.presentation.model.CoinTrackingDisplayable

@Composable
fun CoinTrackingContent(
    coins: List<CoinTrackingDisplayable>,
    modifier: Modifier = Modifier,
    onItemClick: (coinId: String) -> Unit,
) {
    if (coins.isEmpty()) {
        BasicCard(
            modifier = Modifier
                .padding(32.dp)
        ) {
            Text(
                text = "Watch list is empty, click on ★ button to add coin to list",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    } else {
        LazyVerticalGrid(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        )
        {
            items(coins) { coin ->
                CoinTrackingItem(
                    coin = coin,
                    marketStatus = coin.priceChanged1d,
                    onItemClick = { coindId -> onItemClick(coindId) }
                )
            }
        }
    }
}