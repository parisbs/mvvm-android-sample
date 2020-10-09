package com.bajaaquafarms.data.entities.responses

sealed class SourceResponse<out T> {
    class Success<T>(val data: T) : SourceResponse<T>()
    class Failure(val throwable: Throwable) : SourceResponse<Nothing>()
}
