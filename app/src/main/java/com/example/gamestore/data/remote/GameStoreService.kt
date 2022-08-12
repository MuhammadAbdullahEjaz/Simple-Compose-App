package com.example.gamestore.data.remote

import com.example.gamestore.data.model.Games
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query


interface GameStoreService {

    @GET("games")
    suspend fun getGames(
        @HeaderMap header: Map<String, String>,
        @Query("key") key: String,
        @Query("page") page: Int,
        @Query("page_size") page_size: Int
    ): Response<Games>

}