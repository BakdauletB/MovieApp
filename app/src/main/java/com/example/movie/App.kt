package com.example.movie

import android.app.Application
import com.example.movie.di.AppComponent
import com.example.movie.di.DaggerAppComponent
import com.example.movie.di.modules.AppModule
import com.example.movie.di.modules.NetworkModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
    }



}