package com.example.movie.utils.base

import android.app.Application
import com.example.movie.remote.ApiConstants
import com.example.movie.remote.Networking

open class BaseRepository(baseUrl : String  = ApiConstants.API_URL) {

    val networkService = Networking.create(baseUrl)

}