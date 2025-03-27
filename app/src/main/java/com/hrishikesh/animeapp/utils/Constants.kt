package com.hrishikesh.animeapp.utils

class Constants {
    companion object{
        const val BASE_URL = "https://api.jikan.moe/v4/"

        const val TOP_ANIME = BASE_URL + "top/anime"
        const val ANIME_DETAILS = BASE_URL + "anime/{anime_id}"
    }
}