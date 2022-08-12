package com.example.gamestore.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamestore.components.InputTextField
import com.example.gamestore.ui.theme.GameStoreTheme


@Composable
fun HomeScreenTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
    ) {
        var search by remember { mutableStateOf("") }
        var searchVisibility by remember { mutableStateOf(false) }

        Title(visibility = searchVisibility, modifier = Modifier.align(Alignment.Center))

        SearchInput(
            visibility = searchVisibility,
            modifier = Modifier.align(Alignment.Center),
            input = search,
            onValueChange = { it -> search = it })

        SearchIcon(
            visibility = searchVisibility,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            searchVisibility = !searchVisibility
        }

        CrossIcon(
            visibility = searchVisibility,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            search = ""
            searchVisibility = !searchVisibility
        }

    }
}

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    visibility: Boolean,
    input: String,
    onValueChange: (String) -> Unit
) {
    AnimatedVisibility(
        visibility,
        modifier = modifier,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        InputTextField(
            input = input,
            onValueChanged = onValueChange,
            placeholder = {
                Text(
                    text = "Search"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            fontSise = 16.sp
        )
    }
}

@Composable
fun CrossIcon(modifier: Modifier = Modifier, visibility: Boolean, onClick: () -> Unit) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visibility,
        modifier = modifier,
        enter = slideInHorizontally {
            with(density) {
                100.dp.roundToPx()
            }
        } + fadeIn(initialAlpha = 0.3f),
    ) {
        CancelButton(onClick = onClick)
    }
}

@Composable
fun SearchIcon(modifier: Modifier = Modifier, visibility: Boolean, onClick: () -> Unit) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = !visibility,
        modifier = modifier,
        enter = slideInHorizontally {
            with(density) {
                100.dp.roundToPx()
            }
        } + fadeIn(initialAlpha = 0.3f),
    ) {

        SearchBox(onClick = onClick)
    }
}

@Composable
fun Title(modifier: Modifier = Modifier, visibility: Boolean) {
    AnimatedVisibility(
        !visibility,
        modifier = modifier,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        Color.Red,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                ) {
                    append("Game")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp
                    )
                ) {
                    append(" Store")
                }
            },
            Modifier
                .padding(vertical = 6.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun SearchBox(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(onClick = { onClick() }, modifier = modifier) {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
    }
}

@Composable
fun CancelButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(onClick = { onClick() }, modifier = modifier) {
        Icon(imageVector = Icons.Default.Close, contentDescription = null)
    }
}

@Preview
@Composable
fun PreviewSearchBox() {
    GameStoreTheme {
        HomeScreenTopBar()
    }
}
