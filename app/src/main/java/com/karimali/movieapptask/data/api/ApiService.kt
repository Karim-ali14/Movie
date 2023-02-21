package com.karimali.movieapptask.data.api

import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.commin.utils.Constants.Routs.GET_MOVES
import com.karimali.movieapptask.commin.utils.Constants.Routs.GET_MOVE_DETAIlS
import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(GET_MOVES)
    suspend fun fetchAllMoves(
        @Query("api_key") apiKey:String
    ) :ResponseModel<ArrayList<MoveModel>?>?

    @GET(GET_MOVE_DETAIlS) // this hardcoded because GET method take value in compile time
    suspend fun fetchMoveDetails(
        @Path("movie_id") movieId:String,
        @Query("api_key") apiKey:String
    ) : MoveDetailsModel?
}