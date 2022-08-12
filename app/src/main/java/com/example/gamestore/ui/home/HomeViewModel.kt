package com.example.gamestore.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gamestore.data.model.Games
import com.example.gamestore.data.model.Results
import com.example.gamestore.data.remote.repositories.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val gamesRepository: GamesRepository
) : ViewModel() {
    private val _games = MutableStateFlow<HomeScreenState>(HomeScreenState(null,""))
    init {
        getData()
    }
    val games:StateFlow<HomeScreenState> = _games
    fun getData(search:String? = null){
        val gamesPaging:Flow<PagingData<Results>> = gamesRepository.getGames().cachedIn(viewModelScope)
        _games.value = HomeScreenState(gamesPaging)
    }

}
