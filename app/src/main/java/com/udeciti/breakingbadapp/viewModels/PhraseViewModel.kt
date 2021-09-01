package com.udeciti.breakingbadapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udeciti.breakingbadapp.models.Phrase
import com.udeciti.breakingbadapp.services.phraseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhraseViewModel : ViewModel() {
    private var _phrase = MutableLiveData<Phrase>()
    val phrase: LiveData<Phrase>
        get() = _phrase

    init{
        viewModelScope.launch {
            _phrase.value = fetch()
        }
    }

    suspend fun load(){
        _phrase.postValue(fetch())
    }

    private suspend fun fetch() : Phrase{
        return withContext(Dispatchers.IO){
            val phrase = phraseService.getRandomPhrase()!!

            phrase[0]
        }
    }

}