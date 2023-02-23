package com.karimali.movieapptask.commin.utils

object Constants {

    object Links {
        const val BASE_URL = "https://api.themoviedb.org/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }

    object Keys {
        const val API_KEY = "ca3e24e94fc48634f7f57bf82fd9be5d"
        const val MOVE_ID_KEY = "movie_id"
    }

    object Routs {
        const val GET_MOVES = "3/movie/popular"
        const val GET_MOVE_DETAIlS = "3/movie/{movie_id}"
    }

    object Messages {
        const val ERROR = "Oops , something went wrong"
    }
}