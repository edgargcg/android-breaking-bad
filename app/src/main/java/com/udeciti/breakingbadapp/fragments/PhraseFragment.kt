package com.udeciti.breakingbadapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.databinding.FragmentCharactersBinding
import com.udeciti.breakingbadapp.databinding.FragmentPhraseBinding
import com.udeciti.breakingbadapp.fragments.adapters.CharactersListAdapter
import com.udeciti.breakingbadapp.models.Character
import com.udeciti.breakingbadapp.models.Phrase
import com.udeciti.breakingbadapp.viewModels.CharacterViewModel
import com.udeciti.breakingbadapp.viewModels.PhraseViewModel

class PhraseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPhraseBinding.inflate(inflater, container, false)
        val phraseViewModel = ViewModelProvider(this).get(PhraseViewModel::class.java)

        phraseViewModel.phrase.observe(viewLifecycleOwner, Observer<Phrase>{
            phrase ->
                binding.phrase.text = phrase.quote
                binding.author.text = phrase.author
        })

        return binding.root
    }
}