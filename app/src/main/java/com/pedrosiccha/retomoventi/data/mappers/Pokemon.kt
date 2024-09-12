package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.local.entities.PokemonEntity
import com.pedrosiccha.retomoventi.domain.model.Pokemon

fun Pokemon.toEntity(): PokemonEntity {
    return PokemonEntity.fromDomain(
        id = id,
        name = name,
        types = types,
        abilities = abilities,
        attacks = attacks,
        locations = locations
    )
}