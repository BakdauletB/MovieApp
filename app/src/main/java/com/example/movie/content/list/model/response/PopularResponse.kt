package com.example.movie.content.list.model.response

import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("results")
    val results : ArrayList<PopularModel>
)