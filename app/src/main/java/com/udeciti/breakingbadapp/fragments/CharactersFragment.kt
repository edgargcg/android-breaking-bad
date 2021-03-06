package com.udeciti.breakingbadapp.fragments

import android.content.Context
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
import java.lang.ClassCastException

class CharactersFragment : Fragment() {
    public interface CharacterSelectListener{
        fun onCharacterSelected(character: Character)
    }

    private lateinit var characterSelectListener: CharacterSelectListener
    override fun onAttach(context: Context) {
        super.onAttach(context)

        characterSelectListener = try {
            context as CharacterSelectListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement CharacterSelectListener")
        }
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

                adapter.onItemClick = {
                    characterSelectListener.onCharacterSelected(it)
                }

                binding.charactersList.layoutManager = LinearLayoutManager(requireActivity())
                binding.charactersList.adapter = adapter
        })

        return binding.root
    }
}