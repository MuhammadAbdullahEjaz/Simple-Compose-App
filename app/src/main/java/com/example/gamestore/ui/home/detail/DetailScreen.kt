package com.example.gamestore.ui.home.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.gamestore.components.ShimmerEffect
import com.example.gamestore.data.model.Results
import com.example.gamestore.data.model.ScreenShots
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailScreen(game: Results) {
    Column() {

        val pagerState = rememberPagerState()

        HorizontalPager(
            state = pagerState,
            count = game.shortScreenshots.size,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            CarouselImage(screenShot = game.shortScreenshots[page], modifier = Modifier.padding(horizontal = 12.dp))
        }
    }
}

@Composable
fun CarouselImage(screenShot: ScreenShots, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier,
            model = screenShot.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerEffect(height = 300.dp)
            },
        )
    }
}