package com.example.gamestore.ui.home

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.example.gamestore.components.ShimmerEffect
import com.example.gamestore.data.model.Platform
import com.example.gamestore.data.model.Platforms
import com.example.gamestore.data.model.Results

@Composable
fun HomeScreen(viewModel: HomeViewModel, navigateToDetailScreen: (game: Results) -> Unit) {
    Surface {
        val uiState = viewModel.games.collectAsState()
        uiState.value.PagingDataSource?.let {
            val data = it.collectAsLazyPagingItems()
            LazyColumn() {
                items(data.itemCount) {
                    GameCard(
                        game = data[it]!!,
                        modifier = Modifier.padding(16.dp),
                        onGameCardClick = navigateToDetailScreen
                    )
                }
                if (data.loadState.refresh is LoadState.Loading) {
                    items(3) {
                        ShimmerEffect(height = 300.dp, modifier = Modifier.padding(16.dp))
                    }
                } else if (data.loadState.append is LoadState.Loading) {
                    items(3) {
                        ShimmerEffect(height = 300.dp, modifier = Modifier.padding(16.dp))
                    }
                } else if (data.loadState.append is LoadState.Error) {
                    item {
                        Text(text = (data.loadState.append as LoadState.Error).error.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    game: Results,
    onGameCardClick: (game: Results) -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 8.dp,
    ) {
        Column() {
            Log.e("hello", "${game.backgroundImage}")
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clickable { onGameCardClick(game) },
                model = game.backgroundImage,
                contentDescription = " ",
                contentScale = ContentScale.Crop,
                loading = {
                    ShimmerEffect(height = 250.dp)
                }
            )
            game.name?.let {
                Text(
                    text = it,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                )
            }
            PlatformsRow(
                platform = game.platforms,
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun PlatformsRow(platform: List<Platforms>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(platform.size) {
            platform[it].platform?.let { p ->
                PlateForm(
                    platform = p
                )
            }
        }
    }
}

@Composable
fun PlateForm(platform: Platform, modifier: Modifier = Modifier) {
    Card(modifier = modifier.border(1.dp, Color.Black, shape = RoundedCornerShape(3.dp))) {
        Text(text = platform.name!!, modifier = Modifier.padding(3.dp))
    }
}

