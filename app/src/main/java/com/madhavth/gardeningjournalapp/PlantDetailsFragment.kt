package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models.PlantDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlantDetailsFragment : Fragment() {

    private val args: PlantDetailsFragmentArgs by navArgs()

    private val plantDetailViewModel by hiltNavGraphViewModels<PlantDetailViewModel>(R.id.nav_graph_xml)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plant = args.plant
        plantDetailViewModel.setPlant(plant)
        bindViews()
        bindObservers()
    }

    private fun bindViews() {

    }
    private fun bindObservers() {
        plantDetailViewModel.plant.observe(viewLifecycleOwner) {
         plant ->
            if(plant == null) return@observe
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlantDetailsFragment().apply {
            }
    }
}