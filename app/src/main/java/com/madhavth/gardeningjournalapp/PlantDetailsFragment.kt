package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models.PlantDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailsFragment : Fragment() {

    private val plantDetailViewModel by hiltNavGraphViewModels<PlantDetailViewModel>(R.navigation.nav_graph)
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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlantDetailsFragment().apply {
            }
    }
}