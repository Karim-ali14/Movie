package com.karimali.movieapptask.ui.viewmodel

import androidx.lifecycle.ViewModel

import com.karimali.movieapptask.commin.extension.performNetworkOp
import com.karimali.movieapptask.commin.utils.Resource
import com.karimali.movieapptask.data.model.Moves
import com.karimali.movieapptask.data.repository.moveRepo.MoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MoveViewModel @Inject constructor(
    private val moveRepository: MoveRepository
) : ViewModel() {

    private var _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var _hasData = MutableStateFlow<Boolean>(true)
    val hasData: MutableStateFlow<Boolean> get() = _hasData

    private var _hasError = MutableStateFlow<Boolean>(false)
    val hasError: MutableStateFlow<Boolean> get() = _hasError

    private val _move: MutableStateFlow<Resource<Moves?>> = MutableStateFlow(Resource.loading())
    val move: MutableStateFlow<Resource<Moves?>> get() = _move

    init {
        fetchMoves()
    }

    fun fetchMoves() {
        performNetworkOp(
            networkCall =  {
                _isLoading.emit(true)
                moveRepository.fetchAllMoves()
            },
            doOnMainThread = {
                _isLoading.emit(false)
                _hasError.emit(false)
                if (!it?.results.isNullOrEmpty()){
                    _hasData.emit(it?.results?.isNotEmpty() ?: false)
                    _move.emit(Resource.success(it?.results))
                }else{
                    _hasData.emit(false)
                    _move.emit(Resource.error(it?.status_message ?: "")) // Todo set static error massage
                }
            },onError = {
                _isLoading.emit(false)
                _hasError.emit(true)
            }
        )
    }
}