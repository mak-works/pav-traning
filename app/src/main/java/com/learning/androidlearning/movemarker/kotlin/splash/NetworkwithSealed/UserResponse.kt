package com.learning.androidlearning.movemarker.kotlin.splash.NetworkwithSealed

sealed class UserResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : UserResponse<T>()
    data class ResponseFailure<out T : Any>(val data: T) : UserResponse<T>()
    data class ConnectionFailure(val error: Throwable?) : UserResponse<Nothing>()
}