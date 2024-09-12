package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.remote.response.PokemonDetailsResponse
import com.pedrosiccha.retomoventi.domain.model.Pokemon

fun PokemonDetailsResponse.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        types = types.map { it.type.name },       // Extraer los nombres de los tipos
        abilities = abilities.map { it.ability.name }, // Extraer los nombres de las habilidades
        attacks = moves.map { it.move.name },     // Extraer los nombres de los movimientos
        locations = listOf() // Si decides manejar las ubicaciones, puedes implementar esto
    )
}