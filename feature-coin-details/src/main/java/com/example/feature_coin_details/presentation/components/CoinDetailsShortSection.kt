package com.example.feature_coin_details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.design.CustomGreen
import com.example.core.design.CustomRed
import com.example.core.design.LighterGray
import com.example.core.presentation.components.InfoCard

@Composable
internal fun CoinDetailSection(
    price: Double,
    priceChange: Double,
) {
    InfoCard(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 4.dp)
        ) {
            Text(
                text = "$${price.toFloat()}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 4.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(3.dp))
                        .background(LighterGray)
                        .padding(2.dp)
                ) {
                    Text(
                        text = "24h",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = "$priceChange%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (priceChange < 0) CustomRed else CustomGreen
                )

                Image(
                    painter = if (priceChange < 0) painterResource(id = com.example.core.R.drawable.ic_arrow_negative)
                    else painterResource(id = com.example.core.R.drawable.ic_arrow_positive),
                    contentDescription = "arrow",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(12.dp)
                )
            }

        }
    }
}