package com.pedrosiccha.retomoventi.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pedrosiccha.retomoventi.data.local.entities.PokemonEntity

interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemon(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon WHERE name LIKE :name")
    suspend fun searchPokemonByName(name: String): List<PokemonEntity>
}