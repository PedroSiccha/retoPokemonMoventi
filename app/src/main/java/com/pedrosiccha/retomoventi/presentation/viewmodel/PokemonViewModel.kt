package com.pedrosiccha.retomoventi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosiccha.retomoventi.domain.model.Pokemon
import com.pedrosiccha.retomoventi.domain.model.PokemonEvolution
import com.pedrosiccha.retomoventi.domain.usecase.GetAllPokemonUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonDetailsUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonEncounterLocationsUseCase
import com.pedrosiccha.retomoventi.domain.usecase.GetPokemonEvolutionUseCase
import com.pedrosiccha.retomoventi.domain.usecase.SearchPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getAllPokemonUseCase: GetAllPokemonUseCase,
    private val searchPokemonUseCase: SearchPokemonUseCase,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    private val getPokemonEvolutionsUseCase: GetPokemonEvolutionUseCase,
    private val getPokemonEncounterLocationsUseCase: GetPokemonEncounterLocationsUseCase
): ViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    private val _pokemonDetails = MutableLiveData<Pokemon>()
    val pokemonDetails: LiveData<Pokemon> = _pokemonDetails

    private val _pokemonEvolutions = MutableLiveData<List<PokemonEvolution>>()
    val pokemonEvolutions: LiveData<List<PokemonEvolution>> = _pokemonEvolutions

    private val _pokemonEncounterLocations = MutableLiveData<List<String>>()
    val pokemonEncounterLocations: LiveData<List<String>> = _pokemonEncounterLocations
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchAllPokemon()
    }

    private fun fetchAllPokemon() {
        _isLoading.value = true
        viewModelScope.launch {
            val pokemon = getAllPokemonUseCase()
            _pokemonList.value = pokemon
            _isLoading.value = false
        }
    }

    fun searchPokemon(name: String) {
        _isLoading.value = true
        viewModelScope.launch {
            val result = searchPokemonUseCase(name)
            _pokemonList.value = result
            _isLoading.value = false
        }
    }

    fun getPokemonDetails(id: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            val details = getPokemonDetailsUseCase(id)
            _pokemonDetails.value = details
            _isLoading.value = false
        }
    }

    fun getPokemonEvolutions(id: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            val evolutions = getPokemonEvolutionsUseCase(id)
            _pokemonEvolutions.value = evolutions
            _isLoading.value = false
        }
    }

    fun getPokemonEncounterLocations(id: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            val locations = getPokemonEncounterLocationsUseCase(id)
            _pokemonEncounterLocations.value = locations
            _isLoading.value = false
        }
    }

}