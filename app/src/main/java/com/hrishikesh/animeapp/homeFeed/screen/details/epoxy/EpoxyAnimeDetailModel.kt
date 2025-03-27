package com.hrishikesh.animeapp.homeFeed.screen.details.epoxy

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.hrishikesh.animeapp.BR
import com.hrishikesh.animeapp.R

@EpoxyModelClass
abstract class EpoxyAnimeHeaderAndDetails: DataBindingEpoxyModel(){

    @EpoxyAttribute
    var title: String? = ""

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.name, title)
    }
    override fun getDefaultLayout(): Int {
        return R.layout.recycler_anime_title
    }
}