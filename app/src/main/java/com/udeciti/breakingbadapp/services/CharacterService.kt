package com.udeciti.breakingbadapp.services

import com.udeciti.breakingbadapp.models.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface CharacterService {
    @GET("characters")
    suspend fun getAllCharacters(): MutableList<Character>
}

var api =
    Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://www.breakingbadapi.com/api/")
        .build()

var characterService: CharacterService = api.create<CharacterService>(CharacterService::class.java)

