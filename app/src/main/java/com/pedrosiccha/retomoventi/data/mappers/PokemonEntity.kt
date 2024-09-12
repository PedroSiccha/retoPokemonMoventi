package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.local.entities.PokemonEntity
import com.pedrosiccha.retomoventi.domain.model.Pokemon

fun PokemonEntity.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        types = parseTypes(),
        abilities = parseAbilities(),
        attacks = parseAttacks(),
        locations = parseLocations()
    )
}