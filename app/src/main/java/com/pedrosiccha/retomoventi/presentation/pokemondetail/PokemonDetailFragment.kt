package com.pedrosiccha.retomoventi.presentation.pokemondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pedrosiccha.retomoventi.databinding.FragmentPokemonDetailBinding
import com.pedrosiccha.retomoventi.presentation.viewmodel.PokemonViewModel
import androidx.lifecycle.Observer

@AndroidEntryPoint
class PokemonDetailFragment : Fragment() {

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonId = PokemonDetailFragmentArgs.fromBundle(requireArguments()).pokemonId
        viewModel.getPokemonDetails(pokemonId)

        viewModel.pokemonDetails.observe(viewLifecycleOwner, Observer { pokemon ->
            binding.pokemonName.text = pokemon.name
            binding.pokemonTypes.text = pokemon.types.joinToString { it }
            binding.pokemonAbilities.text = pokemon.abilities.joinToString { it }
            binding.pokemonAttacks.text = pokemon.attacks.joinToString { it }
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