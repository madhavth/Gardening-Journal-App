package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import com.madhavth.gardeningjournalapp.databinding.FragmentHomeBinding
import com.madhavth.gardeningjournalapp.features.home.presentation.view_models.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel by hiltNavGraphViewModels<HomeViewModel>(R.navigation.nav_graph)

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        bindObservers()
    }

    private fun bindObservers() {
        homeViewModel.allPlants.observe(viewLifecycleOwner) {

        }
    }

    private fun bindViews() {
        binding.btnLogPlant.setOnClickListener { navigateToGardenLogFragment() }
    }

    fun navigateToPlantDetailsFragment(plant: Plant) {
        val action = HomeFragmentDirections.actionHomeFragmentToPlantDetailsFragment(plant)
        findNavController().navigate(action)
    }
    fun navigateToGardenLogFragment() {
        findNavController().navigate(R.id.action_blankFragment_to_gardenLogFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}