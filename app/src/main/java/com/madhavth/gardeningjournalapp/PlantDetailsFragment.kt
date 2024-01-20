package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import com.madhavth.gardeningjournalapp.databinding.FragmentPlantDetailsBinding
import com.madhavth.gardeningjournalapp.features.plant_details.presentation.page.PlantDetailsScreen
import com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models.PlantDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailsFragment : Fragment() {

    private val args: PlantDetailsFragmentArgs by navArgs()

    private val plantDetailViewModel by viewModels<PlantDetailViewModel>()

    private lateinit var binding: FragmentPlantDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlantDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plant = args.plant
        plantDetailViewModel.setPlant(plant)
        binding.btnLogPlant.setOnClickListener {
            findNavController().navigate(R.id.action_plantDetailsFragment_to_gardenLogFragment)
        }
        binding.composeView.apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )
            setContent {
                MaterialTheme {
                    val myPlant = plantDetailViewModel.plant.collectAsState()
                    PlantDetailsScreen(myPlant.value)
                }
            }
        }
        setPlantView(plant)
    }

    private fun setPlantView(plant: Plant) {
//        binding.apply {
//            tvPlantName.text = plant.name
//            tvPlantType.text = plant.type
//            tvPlantingDate.text = plant.plantingDate
//            tvWateringFrequency.text = plant.wateringFrequency.toString()
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlantDetailsFragment().apply {
            }
    }
}