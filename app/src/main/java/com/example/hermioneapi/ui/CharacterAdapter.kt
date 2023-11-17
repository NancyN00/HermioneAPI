package com.example.hermioneapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hermioneapi.data.Character
import com.example.hermioneapi.databinding.CharacterItemLayoutBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var characters = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemLayoutBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
       val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount() = characters.size

  fun setCharacterList(character :List<Character>){
      this.characters = characters.toMutableList()
      notifyDataSetChanged()
  }

    inner class CharacterViewHolder(val binding: CharacterItemLayoutBinding): ViewHolder(binding.root){

        fun bind(character: Character){
            binding.apply {
                Glide.with(binding.root).load(character.image).into(ivCharacterImg)
                tvCharacterName.text = character.name
                tvCharacterGender.text = character.gender
                tvCharacterHouse.text = character.house
            }
        }

    }
}