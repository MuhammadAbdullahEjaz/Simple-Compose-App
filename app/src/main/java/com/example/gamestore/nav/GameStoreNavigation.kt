package com.example.gamestore.nav


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.gamestore.components.GameStoreScaffold
import com.example.gamestore.data.model.Results
import com.example.gamestore.nav.argsTypes.ResultType
import com.example.gamestore.ui.home.HomeScreen
import com.example.gamestore.ui.home.HomeScreenTopBar
import com.example.gamestore.ui.home.HomeViewModel
import com.example.gamestore.ui.home.detail.DetailScreen
import com.example.gamestore.ui.home.detail.DetailScreenTopBar
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun GameStoreNavigation(
    navController: NavHostController,
    navigationActions: GameStoreNavigationActions,
    systemUiController: SystemUiController
) {
    systemUiController.setStatusBarColor(Color.White)
    NavHost(navController = navController, startDestination = Destinations.Home) {
        navigation(startDestination = Destinations.HomeRoute.HomeMain, route = Destinations.Home) {

            composable(Destinations.HomeRoute.HomeMain) { navBackStackEntry ->
                val parentEntry = remember(navBackStackEntry) {
                    navController.getBackStackEntry(Destinations.Home)
                }
                val homeViewModel = hiltViewModel<HomeViewModel>(parentEntry)
                GameStoreScaffold(topBar = { HomeScreenTopBar(homeViewModel)}) {
                    HomeScreen(homeViewModel, navigationActions.navigateToHomeDetailScreen)
                }
            }

            composable(
                route = "${Destinations.HomeRoute.HomeDetail.name}/{${Destinations.HomeRoute.HomeDetail.args}}",
                arguments = Destinations.HomeRoute.HomeDetail.argsList
            ) { navBackStackEntry ->
                val parentEntry = remember {
                    navBackStackEntry
                }
                val game =
                    navBackStackEntry.arguments?.getParcelable<Results>(Destinations.HomeRoute.HomeDetail.args)
                GameStoreScaffold(topBar = { DetailScreenTopBar(game = game!!)}) {
                    DetailScreen(game = game!!)
                }
            }

        }
    }
}

object Destinations {
    const val Home = "home"

    object HomeRoute {
        const val HomeMain = "home_main"

        object HomeDetail {
            const val name = "home_detail"
            const val args = "game"
            val argsList = listOf(navArgument(args) { type = ResultType() })
        }
    }
}