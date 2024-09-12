package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.remote.response.PokemonStats as RemotePokemonStats
import com.pedrosiccha.retomoventi.domain.model.PokemonStats as DomainPokemonStats

fun List<RemotePokemonStats>.toDomain(): List<DomainPokemonStats> {
    return this.map {
        DomainPokemonStats(
            name = it.name,
            baseStat = it.base_stat
        )
    }
}