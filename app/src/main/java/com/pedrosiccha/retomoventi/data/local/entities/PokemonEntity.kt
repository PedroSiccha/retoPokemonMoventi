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

    fun getTypes(): List<String> = Gson().fromJson(types, Array<String>::class.java).toList()
    fun getAbilities(): List<String> = Gson().fromJson(abilities, Array<String>::class.java).toList()
    fun getAttacks(): List<String> = Gson().fromJson(attacks, Array<String>::class.java).toList()
    fun getLocations(): List<String> = Gson().fromJson(locations, Array<String>::class.java).toList()

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