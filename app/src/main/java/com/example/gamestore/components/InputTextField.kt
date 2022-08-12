package com.example.gamestore.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.gamestore.ui.theme.GameStoreTheme

@Composable
fun InputTextField(
    input: String,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit,
    fontColor:Color = Color.Black,
    placeholder: @Composable () -> Unit,
    fontSise:TextUnit = 16.sp
) {
    BasicTextField(
        modifier = modifier,
        value = input,
        onValueChange = onValueChanged,
        singleLine = true,
        cursorBrush = Brush.linearGradient(listOf(Color.Red, Color.Red)),
        textStyle = TextStyle(fontSize = fontSise, color = fontColor),
    )
}

@Preview
@Composable
fun PreviewInputTextField() {
    GameStoreTheme() {
        InputTextField(input = "", onValueChanged = {}, placeholder = { Text(text = "Place") })
    }
}