package com.retrofit

import com.google.gson.annotations.SerializedName

class MoviesResponse(
        @field:SerializedName("page")
        var page: Int = 0,
        @field:SerializedName("results")
        var results: List<Movie>? = null,
        @field:SerializedName("total_results")
        var totalResults: Int = 0,
        @field:SerializedName("total_pages")
        var totalPages: Int = 0
)