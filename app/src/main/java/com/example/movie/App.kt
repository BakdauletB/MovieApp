package com.example.movie

import android.app.Application
import com.example.movie.di.AppComponent
import com.example.movie.di.DaggerAppComponent
import com.example.movie.di.AppModule

class App : Application() {


     lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }


}