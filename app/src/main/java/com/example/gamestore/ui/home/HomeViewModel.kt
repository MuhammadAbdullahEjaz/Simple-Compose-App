package com.example.gamestore.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gamestore.data.model.Results
import com.example.gamestore.data.remote.repositories.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val gamesRepository: GamesRepository
) : ViewModel() {
    private val _games = MutableStateFlow(HomeScreenState())
    init {
        getData()
    }
    val games:StateFlow<HomeScreenState> = _games
    fun getData(search:String? = null){
        val gamesPaging:Flow<PagingData<Results>> = gamesRepository.getGames(search).cachedIn(viewModelScope)
        _games.value = HomeScreenState(gamesPaging.cachedIn(viewModelScope))
    }

    fun onSearchChange(search:String?){
        val gamesPaging:Flow<PagingData<Results>> = gamesRepository.getGames(search)
        if (search.isNullOrBlank()) {

        }else{
            _games.value = HomeScreenState(gamesPaging.cachedIn(viewModelScope), search = search, true)
        }
    }

    fun resetSearch() {
        if (_games.value.searchVisiblity && _games.value.search.isNotBlank()) {
            val gamesPaging: Flow<PagingData<Results>> =
                gamesRepository.getGames().cachedIn(viewModelScope)
            _games.value = HomeScreenState(gamesPaging.cachedIn(viewModelScope))
        }
    }

}
