package com.example.feature_coins_list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.core.design.CustomGreen
import com.example.core.design.CustomRed
import com.example.core.design.CustomYellow
import com.example.core.design.LighterGray
import com.example.core.presentation.components.BasicCard
import com.example.feature_coins_list.presentation.model.CoinDisplayable

@Composable
internal fun CoinItem(
    coin: CoinDisplayable,
    onItemClick: (CoinDisplayable) -> Unit
) {
    BasicCard(
        modifier = Modifier
            .clickable { onItemClick(coin) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier =
                Modifier
                    .padding(20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(LighterGray)
                            .size(60.dp)
                    ) {
                        AsyncImage(
                            model = coin.icon,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.Center)
                        )
                    }
                }


                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(5f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = coin.name,
                        textAlign = TextAlign.Start
                    )

                    Row {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(LighterGray)
                                .align(Alignment.CenterVertically)
                                .padding(2.dp)
                        ) {
                            Text(
                                text = coin.rank.toString(),
                                fontSize = 10.sp,
                                color = CustomYellow,
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                        Text(
                            text = coin.symbol,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(start = 5.dp)
                        )

                    }

                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .weight(3f)
                ) {
                    Text(
                        text = "$" + coin.price.toFloat().toString(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = coin.priceChange1d.toString() + "%",
                        color = if (coin.priceChange1d < 0) CustomRed else CustomGreen,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

        }

    }
}