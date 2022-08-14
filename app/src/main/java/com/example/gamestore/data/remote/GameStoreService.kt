package com.example.gamestore.data.remote

import com.example.gamestore.data.model.Games
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface GameStoreService {

    @GET("games")
    suspend fun getGames(
        @HeaderMap header: Map<String, String>,
        @QueryMap query: Map<String, String>
    ): Response<Games>
}