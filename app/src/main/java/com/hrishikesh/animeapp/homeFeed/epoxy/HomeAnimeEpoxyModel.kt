package com.hrishikesh.animeapp.homeFeed.epoxy

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.hrishikesh.animeapp.BR
import com.hrishikesh.animeapp.R
import com.hrishikesh.animeapp.homeFeed.callback.HomeAnimeClickCallback

@EpoxyModelClass
abstract class EpoxyHomeAnimeDetails : DataBindingEpoxyModel() {

    @EpoxyAttribute
    var imageUrl: String? = ""

    @EpoxyAttribute
    var animeName: String? = ""

    @EpoxyAttribute
    var numberOfEpisodes: String? = ""

    @EpoxyAttribute
    var ratings: String? = ""

    @EpoxyAttribute
    var animeId: Int? = 0

    @EpoxyAttribute
    lateinit var callback: HomeAnimeClickCallback

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.imageUrl, imageUrl)
        binding.setVariable(BR.animeName, animeName)
        binding.setVariable(BR.episodesNumber, numberOfEpisodes)
        binding.setVariable(BR.rating, ratings)
        binding.setVariable(BR.animeId, animeId)
        binding.setVariable(BR.callback, callback)
    }
    override fun getDefaultLayout(): Int {
        return R.layout.recycler_anime_details_card
    }
}