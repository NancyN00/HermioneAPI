package com.example.hermioneapi.data

import retrofit2.http.GET

interface HarryPotterApi {

    @GET("characters")
    suspend fun getCharacters() : List<Character>


}