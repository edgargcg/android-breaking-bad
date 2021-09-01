package com.udeciti.breakingbadapp.services

import com.udeciti.breakingbadapp.api.api
import com.udeciti.breakingbadapp.models.Character
import retrofit2.http.GET

interface CharacterService {
    @GET("characters")
    suspend fun getAllCharacters(): MutableList<Character>
}

var characterService: CharacterService = api.create<CharacterService>(CharacterService::class.java)

