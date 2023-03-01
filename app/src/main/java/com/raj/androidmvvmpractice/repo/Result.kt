package com.raj.androidmvvmpractice.repo

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: java.lang.Exception) :
        Result<Nothing>()
}