package com.example.gamestore.data.remote.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.gamestore.data.model.Games
import com.example.gamestore.data.model.Results
import com.example.gamestore.data.remote.GameStoreService
import com.example.gamestore.paging.GamesPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class GamesRepository @Inject constructor (val gameStoreService: GameStoreService){

    fun getGames(search:String? = null): Flow<PagingData<Results>> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                enablePlaceholders = true,
            ),
            pagingSourceFactory = {GamesPagingSource(gameStoreService, search)}
        ).flow
    }
}