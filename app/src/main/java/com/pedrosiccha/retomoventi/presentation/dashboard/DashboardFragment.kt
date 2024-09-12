package com.pedrosiccha.retomoventi.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.pedrosiccha.retomoventi.R
import com.pedrosiccha.retomoventi.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)

        binding.btnPokemonList.setOnClickListener {
            navController.navigate(R.id.action_dashboardFragment_to_pokemonListFragment)
        }

        // Navegar a evoluciones
        binding.btnPokemonEvolutions.setOnClickListener {
            navController.navigate(R.id.action_dashboardFragment_to_pokemonEvolutionsFragment)
        }

        // Navegar a ubicaciones
        binding.btnPokemonLocations.setOnClickListener {
            navController.navigate(R.id.action_dashboardFragment_to_pokemonLocationsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}