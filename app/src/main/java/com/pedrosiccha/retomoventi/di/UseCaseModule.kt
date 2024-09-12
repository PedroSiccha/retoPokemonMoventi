package com.pedrosiccha.retomoventi.di

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonEncounterLocationsUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonEvolutionUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonStatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPokemonEvolutionUseCase(repository: PokemonRepository): GetPokemonEvolutionUseCase {
        return GetPokemonEvolutionUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetPokemonEncounterLocationsUseCase(repository: PokemonRepository): GetPokemonEncounterLocationsUseCase {
        return GetPokemonEncounterLocationsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetPokemonStatsUseCase(repository: PokemonRepository): GetPokemonStatsUseCase {
        return GetPokemonStatsUseCase(repository)
    }

}