package com.example.gamestore.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable


@Composable
fun GameStoreScaffold(
    topBar:@Composable ()->Unit,
    body:@Composable ()->Unit,
){
    Scaffold(
        topBar = topBar
    ) {
        body()
    }
}