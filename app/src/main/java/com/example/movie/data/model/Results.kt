package com.example.movie.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    val poster_path: String? = null,
    val adult: Boolean,
    val overview: String,
    val budget : Int,
    val release_date: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdrop_path: String? = null,
    val popularity: Double,
    val revenue: Int,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Double
) : Parcelable