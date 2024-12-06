package com.example.tedu.network

import retrofit2.http.GET
import retrofit2.http.Query

data class JokeApiResponse(val jokes: List<NetworkJoke>)

data class NetworkJoke(
    val id: String,
    val category: String,
    val setup: String,
    val delivery: String
)

interface JokesApiService {
    @GET("joke/Any?&type=twopart") // ;)
    suspend fun fetchJokes(@Query("amount") amount: Int): JokeApiResponse
}
