package com.karimali.movieapptask.data.repository.moveRepo

import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.data.api.ApiService
import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.data.model.ResponseModel
import javax.inject.Inject

class MoveRepositoryImp @Inject constructor(private val service: ApiService): MoveRepository {

    override suspend fun fetchAllMoves(): ResponseModel<ArrayList<MoveModel>?>? =
        service.fetchAllMoves(apiKey = Constants.Keys.API_KEY)

    override suspend fun fetchMoveDetails(movieId: Int): MoveDetailsModel? =
        service.fetchMoveDetails(
            apiKey = Constants.Keys.API_KEY,
            movieId = movieId
        )
}