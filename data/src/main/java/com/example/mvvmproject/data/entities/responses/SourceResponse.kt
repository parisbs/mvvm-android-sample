package com.example.mvvmproject.data.entities.responses

sealed class SourceResponse<out T> {
    object Loading : SourceResponse<Nothing>()
    class Success<T>(val data: T) : SourceResponse<T>()
    class Failure(val throwable: Throwable) : SourceResponse<Nothing>()
}
