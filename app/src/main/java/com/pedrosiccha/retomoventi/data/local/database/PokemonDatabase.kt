package com.pedrosiccha.retomoventi.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pedrosiccha.retomoventi.data.local.converters.Converters
import com.pedrosiccha.retomoventi.data.local.dao.PokemonDao
import com.pedrosiccha.retomoventi.data.local.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}