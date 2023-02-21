package com.karimali.movieapptask.data.repository.moveRepo

import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.data.model.ResponseModel

interface MoveRepository {

    suspend fun fetchAllMoves() : ResponseModel<ArrayList<MoveModel>?>? = null

    suspend fun fetchMoveDetails(movieId:Int) : MoveDetailsModel? = null

}