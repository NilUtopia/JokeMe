package com.demo.jokeme

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokeAPI {

    @Headers("Accept: application/json")
    @GET("/")
    fun getJoke() : Call<Joke>
}