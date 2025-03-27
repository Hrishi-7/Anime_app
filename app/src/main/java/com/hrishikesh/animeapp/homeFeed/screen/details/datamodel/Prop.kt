package com.hrishikesh.animeapp.homeFeed.screen.details.datamodel


import com.google.gson.annotations.SerializedName

data class Prop(
    @SerializedName("from")
    val from: From,
    @SerializedName("to")
    val to: To
)