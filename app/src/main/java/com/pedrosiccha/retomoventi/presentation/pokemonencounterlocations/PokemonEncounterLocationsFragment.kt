package com.pedrosiccha.retomoventi.presentation.pokemonencounterlocations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.pedrosiccha.retomoventi.databinding.FragmentPokemonEncounterLocationsBinding
import com.pedrosiccha.retomoventi.presentation.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonEncounterLocationsFragment : Fragment() {

    private var _binding: FragmentPokemonEncounterLocationsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonEncounterLocationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonId = PokemonEncounterLocationsFragmentArgs.fromBundle(requireArguments()).pokemonId
        viewModel.getPokemonEncounterLocations(pokemonId)

        viewModel.pokemonEncounterLocations.observe(viewLifecycleOwner, Observer { locations ->
            binding.locationsList.adapter = LocationsAdapter(locations)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
