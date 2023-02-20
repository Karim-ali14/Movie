package com.karimali.movieapptask.data.api

import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.Routs.GET_MOVES)
    suspend fun fetchAllMoves(
        @Query("api_key") apiKey:String
    ) :ResponseModel<ArrayList<MoveModel>?>?

    @GET(Constants.Routs.GET_MOVE_DETAIlS)
    suspend fun fetchMoveDetails(
        @Query("api_key") apiKey:String,
        @Path("movie_id") movieId:Int
    ) : MoveDetailsModel?
}