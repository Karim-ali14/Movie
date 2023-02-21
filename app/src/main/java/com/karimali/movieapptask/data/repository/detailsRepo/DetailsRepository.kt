package com.karimali.movieapptask.data.repository.detailsRepo

import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.data.model.ResponseModel

interface DetailsRepository {

    suspend fun fetchMoveDetails(movieId:Int) : MoveDetailsModel? = null

}