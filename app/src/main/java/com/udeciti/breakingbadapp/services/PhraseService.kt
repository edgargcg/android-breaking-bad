package com.udeciti.breakingbadapp.services

import com.udeciti.breakingbadapp.api.api
import com.udeciti.breakingbadapp.models.Phrase
import retrofit2.http.GET

interface PhraseService {
    @GET("quote/random")
    suspend fun getRandomPhrase(): MutableList<Phrase>
}

var phraseService: PhraseService = api.create<PhraseService>(PhraseService::class.java)