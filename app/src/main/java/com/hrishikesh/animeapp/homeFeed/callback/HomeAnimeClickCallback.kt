package com.hrishikesh.animeapp.homeFeed.callback

import com.hrishikesh.animeapp.homeFeed.HomeFragmentDirections
import com.hrishikesh.animeapp.homeFeed.HomeViewModel

class HomeAnimeClickCallback(private val viewModel: HomeViewModel) {

    fun onAnimeClick(animeId: Int) {
        val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(animeId)
        viewModel.updateNavDirection(direction)
    }
}