package com.udeciti.breakingbadapp.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udeciti.breakingbadapp.api.ApiResponse
import com.udeciti.breakingbadapp.services.characterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.udeciti.breakingbadapp.models.Character


class CharacterViewModel : ViewModel() {
    private var _characters = MutableLiveData<MutableList<Character>>()
    val characters: LiveData<MutableList<Character>>
        get() = _characters

    init{
        viewModelScope.launch{
            _characters.value = fetchCharacter()
        }
    }

    private suspend fun fetchCharacter(): MutableList<Character> {
        return withContext(Dispatchers.IO){
            val characterList: MutableList<Character> = characterService.getAllCharacters()

            characterList
        }
    }
}