package com.pedrosiccha.retomoventi.data.remote.response

data class EvolutionChainLink(
    val species: SpeciesDetail,
    val evolves_to: List<EvolutionChainLink>
)
