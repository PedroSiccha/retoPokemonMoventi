package com.pedrosiccha.retomoventi.domain.repository

import com.pedrosiccha.retomoventi.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getAllPokemon(): List<Pokemon>
    suspend fun searchPokemonByName(name: String): List<Pokemon>
    suspend fun getPokemonDetails(id: Int): Pokemon
}