package com.example.movie.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(url: String?) {
    Glide
        .with(this.context)
        .load("https://image.tmdb.org/t/p/w500/" + url)
        .centerCrop()
        .into(this)
}