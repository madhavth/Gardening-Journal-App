package com.madhavth.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.madhavth.gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.madhavth.gardeningjournalapp.features.garden_log.presentation.view_models.GardenLogViewModel

class GardenLogFragment : Fragment() {

    private val gardenLogViewModel by hiltNavGraphViewModels<GardenLogViewModel>(R.navigation.nav_graph)
    private lateinit var binding: FragmentGardenLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGardenLogBinding.inflate(inflater, container, false)
        return binding.root
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