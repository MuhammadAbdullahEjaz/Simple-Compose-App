package com.example.gamestore.ui.home

import androidx.paging.PagingData
import com.example.gamestore.data.model.Games
import com.example.gamestore.data.model.Results
import com.example.gamestore.paging.GamesPagingSource
import kotlinx.coroutines.flow.Flow

data class HomeScreenState(
    val PagingDataSource: Flow<PagingData<Results>>? = null,
    var search:String = "",
    var searchVisiblity:Boolean = false
)
