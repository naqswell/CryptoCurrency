package com.example.core.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
    ) {
        content()
    }
}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        )
    ) {
        content()
    }
}