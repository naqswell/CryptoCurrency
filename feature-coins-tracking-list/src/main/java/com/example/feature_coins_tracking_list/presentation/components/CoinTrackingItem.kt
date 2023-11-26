package com.example.feature_coins_tracking_list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.core.design.LighterGray
import com.example.core.presentation.components.BasicCard
import com.example.feature_coins_tracking_list.presentation.model.CoinTrackingDisplayable

@Composable
internal fun CoinTrackingItem(
    modifier: Modifier = Modifier,
    coin: CoinTrackingDisplayable,
    marketStatus: Double? = 0.0,
    onItemClick: (coinId: String) -> Unit
) {

    BasicCard(
        modifier = modifier
            .clickable { onItemClick(coin.coinId) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(LighterGray)
                    .size(80.dp)
            ) {
                AsyncImage(
                    model = coin.icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = coin.symbol ?: "",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Bottom)
            )

            Icon(
                modifier = Modifier,
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null
            )

        }


    }
}