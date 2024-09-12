package com.pedrosiccha.retomoventi.presentation.pokemonevolution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedrosiccha.retomoventi.R
import com.pedrosiccha.retomoventi.domain.model.PokemonEvolution

class EvolutionsAdapter(private val evolutions: List<PokemonEvolution>) : RecyclerView.Adapter<EvolutionsAdapter.EvolutionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evolution, parent, false)
        return EvolutionViewHolder(view)
    }

    override fun onBindViewHolder(holder: EvolutionViewHolder, position: Int) {
        val evolution = evolutions[position]
        holder.bind(evolution)
    }

    override fun getItemCount(): Int = evolutions.size

    class EvolutionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(evolution: PokemonEvolution) {
            itemView.findViewById<TextView>(R.id.tvEvolutionName).text = evolution.name
        }
    }
}
