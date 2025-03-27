package com.hrishikesh.animeapp.homeFeed.screen.details.source

import com.hrishikesh.animeapp.homeFeed.screen.details.datamodel.AnimeDetails
import com.hrishikesh.animeapp.utils.Constants
import com.hrishikesh.animeapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

class DetailsAnimeRepository @Inject constructor(
    val retrofit: Retrofit
) {

    private val service = retrofit.create(DetailsAnimeService::class.java)

    suspend fun getAnimeDetails(animeId: Int) : Result<AnimeDetails> {
        return withContext(Dispatchers.IO) {
            try {
                val response = service.getAnimeDetails(animeId)
                Result.Success(response)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    interface DetailsAnimeService{
        @GET(Constants.ANIME_DETAILS)
        suspend fun getAnimeDetails(
            @Path("anime_id") animeId: Int
        ): AnimeDetails
    }
}