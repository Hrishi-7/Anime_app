package com.hrishikesh.animeapp.homeFeed.screen.details.datamodel


import com.google.gson.annotations.SerializedName

data class AnimeDetails(
    @SerializedName("data")
    val result: Data
)