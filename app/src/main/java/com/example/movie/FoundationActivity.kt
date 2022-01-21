package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.common.views.BaseActivity

class FoundationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation)
    }
}