package com.pedrosiccha.retomoventi.data.local.database

import androidx.room.RoomDatabase
import com.pedrosiccha.retomoventi.data.local.dao.PokemonDao

abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}