package com.udeciti.breakingbadapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.models.Character
import com.udeciti.breakingbadapp.viewModels.CharacterViewModel

class CharactersFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        characterViewModel.characters.observe(this, Observer<MutableList<Character>>{
            characterList ->
            for (value: Character in characterList){
                Log.i("edg",  value.char_id.toString())
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }
}