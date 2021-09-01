package com.udeciti.breakingbadapp.fragments.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udeciti.breakingbadapp.R
import com.udeciti.breakingbadapp.databinding.CharacterListItemBinding
import com.udeciti.breakingbadapp.models.Character

class CharactersListAdapter(private val characters:  List<Character>) :  RecyclerView.Adapter<CharactersListAdapter.ViewHolder>(){

    lateinit var onItemClick: (Character) -> Unit

    inner class ViewHolder(private val binding: CharacterListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character){
            val statusImage = when(character.status.toString().lowercase()){
                "alive" -> R.drawable.alive
                "deceased" -> R.drawable.dead
                else -> R.drawable.unknown
            }

            binding.name.text = character.name
            binding.nickname.text = character.nickname
            binding.profileImage.setImageURI(Uri.parse(character.img))
            binding.status.setImageResource(statusImage)
            Glide
                .with(binding.root)
                .load(character.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.profileImage)
            binding.root.setOnClickListener(){
                if (::onItemClick.isInitialized){
                    onItemClick(character)
                }else{
                    Log.i("edgCharacterListAdapter", "onGameClick is not initialized")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.count()
    }
}