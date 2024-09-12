package com.pedrosiccha.retomoventi.presentation.pokemonevolution

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.pedrosiccha.retomoventi.databinding.FragmentPokemonEvolutionsBinding
import com.pedrosiccha.retomoventi.presentation.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonEvolutionsFragment : Fragment() {

    private var _binding: FragmentPokemonEvolutionsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonEvolutionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonId = PokemonEvolutionsFragmentArgs.fromBundle(requireArguments()).pokemonId
        viewModel.getPokemonEvolutions(pokemonId)

        viewModel.pokemonEvolutions.observe(viewLifecycleOwner, Observer { evolutions ->
            binding.evolutionsList.adapter = EvolutionsAdapter(evolutions)
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
