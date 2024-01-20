package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.madhavth.gardeningjournalapp.core.data.AppPreference
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import com.madhavth.gardeningjournalapp.databinding.FragmentHomeBinding
import com.madhavth.gardeningjournalapp.features.home.data.PlantsAdapter
import com.madhavth.gardeningjournalapp.features.home.presentation.view_models.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel by viewModels<HomeViewModel>()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var plantsAdapter: PlantsAdapter

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
        // add dummy data for now
        checkIfFirstLaunch()
    }

    private fun checkIfFirstLaunch() {
        val appPreference = AppPreference(context?: return)
        if(appPreference.isFirstLaunch) {
            lifecycleScope.launch {
                Timber.d("First launch")
                // load dummy data
                homeViewModel.addDummyData()
                appPreference.isFirstLaunch = false
            }
        }
    }

    private fun bindObservers() {
        homeViewModel.allPlants.observe(viewLifecycleOwner) {
            binding.rvPlants.visibility = if(it.isNotEmpty()) View.VISIBLE else View.GONE
            binding.tvNoPlantsAdded.visibility = if(it.isEmpty()) View.VISIBLE else View.GONE
            plantsAdapter.submitList(it)
        }
    }

    private fun bindViews() {
        binding.btnLogPlant.setOnClickListener { navigateToGardenLogFragment() }
        plantsAdapter = PlantsAdapter {
            navigateToPlantDetailsFragment(it)
        }
        binding.rvPlants.adapter = plantsAdapter
    }

    private fun navigateToPlantDetailsFragment(plant: Plant) {
        val action = HomeFragmentDirections.actionHomeFragmentToPlantDetailsFragment(plant)
        findNavController().navigate(action)
    }
    private fun navigateToGardenLogFragment() {
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