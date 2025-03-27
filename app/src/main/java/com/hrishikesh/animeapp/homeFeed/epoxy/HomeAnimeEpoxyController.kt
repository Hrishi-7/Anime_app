package com.hrishikesh.animeapp.homeFeed.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.hrishikesh.animeapp.homeFeed.callback.HomeAnimeClickCallback
import com.hrishikesh.animeapp.homeFeed.datamodel.HomeAnimeDataModel

class HomeAnimeEpoxyController(private val clickCallback: HomeAnimeClickCallback) : TypedEpoxyController<HomeAnimeDataModel>() {
    override fun buildModels(data: HomeAnimeDataModel?) {
        data?.result?.forEach {
            epoxyHomeAnimeDetails {
                id(it.malId)
                imageUrl(it.images?.jpg?.imageUrl)
                animeName(it.titleEnglish)
                ratings(it.rating)
                numberOfEpisodes(it.episodes.toString())
                animeId(it.malId)
                callback(this@HomeAnimeEpoxyController.clickCallback)
            }
        }
    }

}