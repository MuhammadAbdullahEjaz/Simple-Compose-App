package com.example.gamestore.nav

import android.net.Uri
import androidx.navigation.NavHostController
import com.example.gamestore.data.model.Results
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class GameStoreNavigationActions(private val navHostController: NavHostController) {
        val navigateToHomeDetailScreen:(game:Results)->Unit = {
            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            val resultsAdapter = moshi.adapter(Results::class.java)
            val resultJson = Uri.encode(resultsAdapter.toJson(it))
            navHostController.navigate("${Destinations.HomeRoute.HomeDetail.name}/$resultJson"){
                launchSingleTop = true
            }
        }
}