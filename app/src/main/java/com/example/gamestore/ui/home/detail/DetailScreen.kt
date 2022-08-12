package com.example.gamestore.ui.home.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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

@Composable
fun DetailScreen(game: Results) {
    Column() {
        game.backgroundImage?.let {
            BannerImage(imageURL = it)
        }
        game.shortScreenshots.let {
            ScreenShotsRow(screenShots = it, modifier = Modifier.padding(vertical = 6.dp))
        }
    }
}

@Composable
fun BannerImage(imageURL: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier,
            model = imageURL,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerEffect(height = 300.dp)
            },
        )
    }
}

@Composable
fun ScreenShotsRow(
    screenShots: List<ScreenShots>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(horizontal = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(screenShots.size) {
            ScreenShot(screenShot = screenShots[it])
        }
    }
}

@Composable
fun ScreenShot(screenShot: ScreenShots, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            model = screenShot.image,
            contentDescription = null,
            loading = {
                ShimmerEffect(height = 100.dp)
            },
            contentScale = ContentScale.Crop
        )
    }
}