package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.madhavth.gardeningjournalapp.features.garden_log.presentation.view_models.GardenLogViewModel

class GardenLogFragment : Fragment() {

    private val gardenLogViewModel by hiltNavGraphViewModels<GardenLogViewModel>(R.navigation.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_garden_log, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GardenLogFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}