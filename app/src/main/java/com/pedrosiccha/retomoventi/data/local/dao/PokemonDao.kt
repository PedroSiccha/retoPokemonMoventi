package com.pedrosiccha.retomoventi.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pedrosiccha.retomoventi.data.local.entities.PokemonEntity
import kotlinx.coroutines.flow.Flow

interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon WHERE name LIKE :name")
    fun searchPokemonByName(name: String): Flow<List<PokemonEntity>>

    @Query("DELETE FROM pokemon")
    suspend fun clearAllPokemon()
}