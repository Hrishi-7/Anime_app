package com.hrishikesh.animeapp.homeFeed.datamodel


import com.google.gson.annotations.SerializedName

data class To(
    @SerializedName("day")
    val day: Int,
    @SerializedName("month")
    val month: Int,
    @SerializedName("year")
    val year: Int
)