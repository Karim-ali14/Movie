package com.karimali.movieapptask.data.repository

import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.data.model.ResponseModel

interface MainRepository {

    suspend fun fetchAllMoves() : ResponseModel<ArrayList<MoveModel>?>? = null

    suspend fun fetchMoveDetails(movieId:Int) : MoveDetailsModel? = null

}