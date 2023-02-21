package com.karimali.movieapptask.commin.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.lang.Exception

fun <T> ViewModel.performNetworkOp(
    networkCall: suspend () -> T,
    doOnMainThread: suspend (T) -> Unit,
    onError: suspend (Exception?) -> Unit
) {
    viewModelScope.launch(Dispatchers.IO) {
        try {
            val data = networkCall()
            withContext(Dispatchers.Main) {
                doOnMainThread(data)
            }
        }catch (e: Exception){
            onError(e)
        }
    }
}