package com.example.feature_coin_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.core.design.CustomYellow
import com.example.core.design.TextWhite
import com.example.core.presentation.components.BackStackButton

@Composable
internal fun TopBarCoinDetail(
    coinSymbol: String?,
    icon: String?,
    onNavigateBack: () -> Unit,
    isTracking: Boolean,
    onClick: () -> Unit
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {

            Box(
                modifier = Modifier
                    .weight(2f),
                contentAlignment = Alignment.CenterStart
            ) {
                BackStackButton(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    onNavigateBack()
                }
            }
            Box(
                modifier = Modifier
                    .weight(6f),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val padding = 4.dp

                    AsyncImage(
                        model = icon,
                        contentDescription = "Icon",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(padding)
                    )
                    coinSymbol?.let { symbol ->
                        Text(
                            text = symbol,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .padding(padding)
                        )
                    }

                }
            }
            Box(
                modifier = Modifier
                    .weight(2f),
                contentAlignment = Alignment.CenterEnd
            ) {

                FavoriteButton(
                    modifier = Modifier.padding(8.dp),
                    isTracking = isTracking,
                    onClick = onClick
                )
            }

        }
        Divider(Modifier.fillMaxWidth())
    }

}

@Composable
private fun FavoriteButton(
    modifier: Modifier = Modifier,
    isTracking: Boolean,
    onClick: () -> Unit
) {
    IconToggleButton(
        checked = isTracking,
        onCheckedChange = { onClick() }
    ) {
        Icon(
            tint = if (isTracking) CustomYellow else TextWhite,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isTracking) Icons.Filled.Star else Icons.Default.Star,
            contentDescription = null
        )
    }

}