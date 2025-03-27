package com.hrishikesh.animeapp.homeFeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.hrishikesh.animeapp.homeFeed.datamodel.HomeAnimeDataModel
import com.hrishikesh.animeapp.homeFeed.source.HomeAnimeRepository
import com.hrishikesh.animeapp.utils.Event
import com.hrishikesh.animeapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: HomeAnimeRepository
): ViewModel() {

    private val _homeAnime: MutableLiveData<HomeAnimeDataModel> = MutableLiveData()
    val homeAnime: LiveData<HomeAnimeDataModel> get() = _homeAnime

    private val _navDirection: MutableLiveData<Event<NavDirections>> = MutableLiveData()
    val navDirections: LiveData<Event<NavDirections>> = _navDirection

    init {
        getTopAnime()
    }

    private fun getTopAnime() {
        viewModelScope.launch {
            val response = repository.getTopAnime(1)
            if(response is Result.Success) {
                _homeAnime.postValue(response.data)
            }
        }
    }

    fun updateNavDirection(navDirections: NavDirections) {
        _navDirection.postValue(Event(navDirections))
    }
}