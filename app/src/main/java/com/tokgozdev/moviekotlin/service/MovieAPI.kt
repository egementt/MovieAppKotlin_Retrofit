package com.tokgozdev.moviekotlin.service

import com.tokgozdev.moviekotlin.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieAPI {

    //https://www.omdbapi.com/
    //https://www.omdbapi.com/?s=Batman&apikey=apikey

    @GET(" ")
    fun getData(
        @Query("s") movie: String,
        @Query("apikey") apikey: String
    ): Call<Movie>

}