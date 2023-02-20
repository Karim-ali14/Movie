package com.karimali.movieapptask.data.model

data class ResponseModel<T> (
    var status_code : String,
    var status_message : String,
    var results : T
)

