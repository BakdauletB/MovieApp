package com.example.movie

import androidx.annotation.NonNull
import androidx.annotation.Nullable

class Resources<T>private constructor(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(@Nullable data: T): Resources<T> {
            return Resources(Status.SUCCESS, data, null)
        }

        fun <T> error(@NonNull msg: String, @Nullable data: T?): Resources<T> {
            return Resources<T>(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T): Resources<T> {
            return Resources<T>(Status.LOADING, data, null)
        }
    }
}