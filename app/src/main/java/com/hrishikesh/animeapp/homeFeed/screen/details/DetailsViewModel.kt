package com.hrishikesh.animeapp.homeFeed.screen.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrishikesh.animeapp.homeFeed.screen.details.datamodel.AnimeDetails
import com.hrishikesh.animeapp.homeFeed.screen.details.source.DetailsAnimeRepository
import com.hrishikesh.animeapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    val repository: DetailsAnimeRepository
): ViewModel() {

    private val _animeDetails = MutableLiveData<AnimeDetails>()
    val animeDetails: LiveData<AnimeDetails> get() = _animeDetails

    fun getAnimeDetails(animeId: Int) {
        viewModelScope.launch {
            val response = repository.getAnimeDetails(animeId)
            if(response is Result.Success) {
                _animeDetails.postValue(response.data)
            }
        }
    }
}