package com.example.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.example.core.design.TextWhite

@Composable
fun BackStackButton(
    modifier: Modifier = Modifier,
    color: Color = TextWhite,
    onCLick: () -> Unit
) {
    IconButton(onClick = { onCLick() }) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = Icons.Outlined.KeyboardArrowLeft,
            contentDescription = null
        )
    }
}