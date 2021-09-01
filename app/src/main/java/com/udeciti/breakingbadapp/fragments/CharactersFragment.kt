package com.udeciti.breakingbadapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.databinding.FragmentCharactersBinding
import com.udeciti.breakingbadapp.fragments.adapters.CharactersListAdapter
import com.udeciti.breakingbadapp.models.Character
import com.udeciti.breakingbadapp.viewModels.CharacterViewModel

class CharactersFragment : Fragment() {
    public interface CharacterSelected{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)

        characterViewModel.characters.observe(viewLifecycleOwner, Observer<MutableList<Character>>{
            characterList ->
                val adapter = CharactersListAdapter(characterList)
                binding.charactersList.layoutManager = LinearLayoutManager(requireActivity())
                binding.charactersList.adapter = adapter
        })

        return binding.root
    }
}