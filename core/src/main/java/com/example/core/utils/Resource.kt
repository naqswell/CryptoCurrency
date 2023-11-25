package com.example.core.utils

sealed class Resource<out T> {
    data class Success<T>(val data: T?) : Resource<T>()
    data class Error(val t: Throwable? = null) : Resource<Nothing>()
    data class Loading<T>(val data: T? = null) : Resource<T>()
}