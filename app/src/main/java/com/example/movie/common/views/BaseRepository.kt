package com.example.movie.common.views

import android.app.Application
import android.content.Context
import com.example.movie.common.remote.ApiConstants
import com.example.movie.common.remote.Networking

open class BaseRepository(application: Application,baseUrl : String  = ApiConstants.API_URL) {

    val networkService =
        Networking.create(baseUrl)

}