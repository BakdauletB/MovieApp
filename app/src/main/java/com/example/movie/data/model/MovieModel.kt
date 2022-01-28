package com.example.movie.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val poster_path: String? = null,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("id")
    val id : Int,
    @SerializedName("vote_average")
    val vote_average : Float,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("popularity"            ) var popularity          : Double?                   = null,
    @SerializedName("status"                ) var status              : String?                   = null,
    @SerializedName("genres"                ) var genres              : List<Genres>              = arrayListOf(),
    @SerializedName("tagline"               ) var tagline             : String?                   = null,
    @SerializedName("imdb_id"               ) var imdbId              : String?                   = null,



    )