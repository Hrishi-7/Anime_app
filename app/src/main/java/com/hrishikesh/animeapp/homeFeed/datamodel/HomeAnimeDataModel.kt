package com.hrishikesh.animeapp.homeFeed.datamodel


import com.google.gson.annotations.SerializedName

data class HomeAnimeDataModel(
    @SerializedName("data")
    val result: List<Data>?,
    @SerializedName("pagination")
    val pagination: Pagination
)