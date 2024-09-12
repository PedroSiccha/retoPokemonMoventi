package com.pedrosiccha.retomoventi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "pokemon")
data class PokemonEntity (
    @PrimaryKey val id: Int,
    val name: String,
    val types: String,
    val abilities: String,
    val attacks: String,
    val locations: String
) {

    fun parseTypes(): List<String> {
        return if (types.isNullOrEmpty()) {
            emptyList()
        } else {
            Gson().fromJson(types, Array<String>::class.java).toList()
        }
    }

    fun parseAbilities(): List<String> {
        return if (abilities.isNullOrEmpty()) {
            emptyList()
        } else {
            Gson().fromJson(abilities, Array<String>::class.java).toList()
        }
    }

    fun parseAttacks(): List<String> {
        return if (attacks.isNullOrEmpty()) {
            emptyList()
        } else {
            Gson().fromJson(attacks, Array<String>::class.java).toList()
        }
    }

    fun parseLocations(): List<String> {
        return if (locations.isNullOrEmpty()) {
            emptyList()
        } else {
            Gson().fromJson(locations, Array<String>::class.java).toList()
        }
    }

    companion object {
        fun fromDomain(
            id: Int,
            name: String,
            types: List<String>,
            abilities: List<String>,
            attacks: List<String>,
            locations: List<String>
        ): PokemonEntity {
            return PokemonEntity(
                id = id,
                name = name,
                types = Gson().toJson(types),
                abilities = Gson().toJson(abilities),
                attacks = Gson().toJson(attacks),
                locations = Gson().toJson(locations)
            )
        }
    }
}