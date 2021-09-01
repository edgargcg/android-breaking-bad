package com.udeciti.breakingbadapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udeciti.breakingbadapp.databinding.FragmentPhraseBinding
import com.udeciti.breakingbadapp.models.Phrase
import com.udeciti.breakingbadapp.viewModels.PhraseViewModel
import kotlinx.coroutines.*

class PhraseFragment : Fragment() {

    private lateinit var binding: FragmentPhraseBinding
    private lateinit var phraseViewModel: PhraseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhraseBinding.inflate(inflater, container, false)
        phraseViewModel = ViewModelProvider(this).get(PhraseViewModel::class.java)

        phraseViewModel.phrase.observe(viewLifecycleOwner, Observer<Phrase>{
                phrase ->
            binding.phrase.text = phrase.quote
            binding.author.text = phrase.author
        })

        binding.root.setOnClickListener(){
            GlobalScope.launch (Dispatchers.IO) {
                phraseViewModel.load()
            }
        }

        return binding.root
    }
}