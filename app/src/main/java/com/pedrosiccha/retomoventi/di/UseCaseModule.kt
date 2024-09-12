package com.pedrosiccha.retomoventi.di

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository
import com.pedrosiccha.retomoventi.domain.usecase.GetAllPokemonUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonDetailsUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonEncounterLocationsUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonEvolutionUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonStatsUseCase
import com.pedrosiccha.retomoventi.domain.usecase.SearchPokemonUseCase
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

    @Provides
    @Singleton
    fun provideGetAllPokemonUseCase(repository: PokemonRepository): GetAllPokemonUseCase {
        return GetAllPokemonUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSearchPokemonUseCase(repository: PokemonRepository): SearchPokemonUseCase {
        return SearchPokemonUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetPokemonDetailsUseCase(repository: PokemonRepository): GetPokemonDetailsUseCase {
        return GetPokemonDetailsUseCase(repository)
    }

}