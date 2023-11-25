package com.example.feature_coins_list.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feature_coins_list.presentation.model.CoinDisplayable

@Composable
internal fun CoinsPaginationContent(
    modifier: Modifier = Modifier,
    coins: List<CoinDisplayable>,
    buffer: Int = 2,
    isLoading: Boolean,
    onItemlick: (id: String) -> Unit,
    getItems: suspend () -> Unit,
) {

    val lazyGridState = rememberLazyListState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            val layoutInfo = lazyGridState.layoutInfo
            val lastVisibleIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            return@derivedStateOf lastVisibleIndex > (layoutInfo.totalItemsCount - buffer)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value) {
            getItems.invoke()
        }
    }

    LazyColumn(
        state = lazyGridState,
        modifier = modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(items = coins) { index, item ->
            CoinItem(coin = item) {
                onItemlick(item.id)
            }
        }

        item {
            if (isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }

}