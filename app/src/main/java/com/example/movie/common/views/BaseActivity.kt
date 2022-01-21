package com.example.movie.common.views

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.findNavController
import com.example.movie.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun navigateTo(navDirections: Int){
        findNavController(R.id.container)
            .navigate(navDirections)
    }
}