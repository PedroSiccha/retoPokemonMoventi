package com.pedrosiccha.retomoventi.presentation.pokemonlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.pedrosiccha.retomoventi.domain.model.Pokemon
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pedrosiccha.retomoventi.databinding.ItemPokemonBinding

class PokemonListAdapter(private val onItemClick: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonListAdapter.PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon, onItemClick: (Pokemon) -> Unit) {
            binding.pokemonName.text = pokemon.name
            binding.root.setOnClickListener { onItemClick(pokemon) }
        }
    }

    class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}