package com.example.gamestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.gamestore.nav.GameStoreNavigation
import com.example.gamestore.nav.GameStoreNavigationActions
import com.example.gamestore.ui.theme.GameStoreTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameStoreTheme {

                val navHostController = rememberNavController()
                val systemUiController = rememberSystemUiController()
                val navigationActions = GameStoreNavigationActions(navHostController)
                GameStoreNavigation(
                    navController = navHostController,
                    navigationActions = navigationActions,
                    systemUiController = systemUiController
                )
            }
        }
    }
}
