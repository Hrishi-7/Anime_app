package com.hrishikesh.animeapp.homeFeed.source

import com.hrishikesh.animeapp.homeFeed.datamodel.Data
import com.hrishikesh.animeapp.homeFeed.datamodel.HomeAnimeDataModel
import com.hrishikesh.animeapp.utils.Constants
import com.hrishikesh.animeapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class HomeAnimeRepository @Inject constructor(
    val retrofit: Retrofit
) {

    private val service = retrofit.create(HomeAnimeInterface::class.java)

    suspend fun getTopAnime(pageNumber: Int): Result<HomeAnimeDataModel>{
        return withContext(Dispatchers.IO) {
            try{
                val response = service.getTopAnime(pageNumber)
                Result.Success(response)
            }catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    interface HomeAnimeInterface {

        @GET(Constants.TOP_ANIME)
        suspend fun getTopAnime(
            @Query("page") pageNumber: Int
        ) : HomeAnimeDataModel
    }
}