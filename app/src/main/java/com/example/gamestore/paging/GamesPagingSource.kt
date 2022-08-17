package com.example.gamestore.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gamestore.data.model.Results
import com.example.gamestore.data.remote.GameStoreService
import retrofit2.HttpException
import java.io.IOException

class GamesPagingSource(private val gameStoreService: GameStoreService, private val search:String?): PagingSource<Int, Results>() {
    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey ?:
            state.closestPageToPosition(it)?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        val page = params.key ?: 1

        return try {
            val headers = mutableMapOf<String, String>()
            headers["X-RapidAPI-Key"] = "b41419b242mshb52d15f8efb676fp16d829jsn1fa2e1d2add4"
            headers["X-RapidAPI-Host"] = "rawg-video-games-database.p.rapidapi.com"
            headers["User-Agent"] = "GameStore"

            val query = mutableMapOf<String, String>()
            query["key"] = "47f3f29c65304feb85e5a11e75d617ec"
            query["page"] = "$page"
            query["page_size"] = "${params.loadSize}"

            search?.let {
                query["search"] = it
            }

            val response = gameStoreService.getGames(headers, query)
            if(response.isSuccessful){
                 LoadResult.Page(
                    data = response.body()!!.results!!,
                    prevKey = if(page == 1) null else page-1,
                    nextKey = page + 1,
                )
            }else{
                LoadResult.Error(throwable = Throwable(response.errorBody().toString()))
            }
        } catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }

    }

}