package com.hrishikesh.animeapp.homeFeed.screen.details.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.hrishikesh.animeapp.homeFeed.screen.details.datamodel.AnimeDetails

class EpoxyAnimeDetailController: TypedEpoxyController<AnimeDetails>() {
    override fun buildModels(data: AnimeDetails?) {

        data?.let {

            epoxyAnimeHeaderAndDetails {
                id(it.result.malId)
                title(it.result.titleEnglish)
            }

            epoxyAnimeHeaderAndDetails {
                id("synopsis")
                title("Synopsis")
            }

            epoxyAnimeHeaderAndDetails {
                id(it.result.source)
                title(it.result.synopsis)
            }

            epoxyAnimeHeaderAndDetails {
                id("genre")
                title("Genre")
            }

            it.result.genres.forEach {
                epoxyAnimeHeaderAndDetails {
                    id(it.malId)
                    title(it.name)
                }
            }

            epoxyAnimeHeaderAndDetails {
                id("Number of episodes")
                title("Number of episodes")
            }

            epoxyAnimeHeaderAndDetails {
                id("episodes")
                title(it.result.episodes.toString())
            }

            epoxyAnimeHeaderAndDetails {
                id("rated")
                title("Rated")
            }

            epoxyAnimeHeaderAndDetails {
                id("rating")
                title(it.result.rating)
            }
        }
    }
}