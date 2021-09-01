package com.udeciti.breakingbadapp.activities.character_profile

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.adapters.DataListAdapter
import com.udeciti.breakingbadapp.databinding.ActivityCharacterProfileBinding
import com.udeciti.breakingbadapp.fragments.adapters.CharactersListAdapter
import com.udeciti.breakingbadapp.models.Character
import com.udeciti.breakingbadapp.models.Data

class CharacterProfileActivity : AppCompatActivity() {
    companion object {
        const val CHARACTER_KEY = "character_selected"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCharacterProfileBinding>(this, R.layout.activity_character_profile)
        val character = intent.getParcelableExtra<Character>(CHARACTER_KEY)!!
        val statusImage = when(character.status.toString().lowercase()){
            "alive" -> R.drawable.alive
            "deceased" -> R.drawable.dead
            else -> R.drawable.unknown
        }
        val information = mutableListOf<Data>(
            Data(statusImage, "Is ${character.status}"),
            Data(R.drawable.point, "Born in ${character.birthday}"),
            Data(R.drawable.point, "Occupation: ${character.occupation?.joinToString(", ")}"),
            Data(R.drawable.point, "Performed by: ${character.portrayed}"),
        )

        binding.name.text = character.name
        binding.nickname.text = character.nickname
        Glide
            .with(binding.root)
            .load(character.img)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.image)

        val adapter = DataListAdapter(information)
        binding.data.layoutManager = LinearLayoutManager(this)
        binding.data.adapter = adapter
    }
}