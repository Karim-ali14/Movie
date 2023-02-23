package com.karimali.movieapptask.ui.viewmodel

import androidx.lifecycle.ViewModel

import com.karimali.movieapptask.commin.extension.performNetworkOp
import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.commin.utils.Resource
import com.karimali.movieapptask.data.model.MoveDetailsModel
import com.karimali.movieapptask.data.repository.detailsRepo.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
) : ViewModel() {

    private var _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var _hasData = MutableStateFlow<Boolean>(true)
    val hasData: MutableStateFlow<Boolean> get() = _hasData

    private var _hasError = MutableStateFlow<Boolean>(false)
    val hasError: MutableStateFlow<Boolean> get() = _hasError

    private val _moveDetails: MutableStateFlow<Resource<MoveDetailsModel?>> = MutableStateFlow(Resource.loading())
    val moveDetails: MutableStateFlow<Resource<MoveDetailsModel?>> get() = _moveDetails


    fun fetchMoveDetails(moveId:Int) {
        performNetworkOp(
            networkCall =  {
                _isLoading.emit(true)
                detailsRepository.fetchMoveDetails(moveId)
            },
            doOnMainThread = {
                _isLoading.emit(false)
                if (it != null){
                    _hasData.emit(false)
                    _moveDetails.emit(Resource.success(it))
                }else{
                    _moveDetails.emit(Resource.error(it ?: Constants.Messages.ERROR))
                }
            },onError = {
                _isLoading.emit(false)
                _hasError.emit(true)
            }
        )
    }
}