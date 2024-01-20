package com.madhavth.gardeningjournalapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.madhavth.gardeningjournalapp.core.domain.entities.PlantData
import com.madhavth.gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.madhavth.gardeningjournalapp.features.garden_log.presentation.view_models.GardenLogViewModel
import kotlinx.coroutines.launch

class GardenLogFragment : Fragment() {

    private val gardenLogViewModel by viewModels<GardenLogViewModel>()
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
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        binding.btnAddPlant.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                onSaveClicked()
            }
        }
        addTextChangedListener(binding.etPlantName) {
            gardenLogViewModel.onNameChanged(it)
        }

        addTextChangedListener(binding.etPlantType) {
            gardenLogViewModel.onTypeChanged(it)
        }

        addTextChangedListener(binding.etPlantWateringFrequency) {
            gardenLogViewModel.onWateringFrequencyChanged(it.toIntOrNull() ?: 0)
        }

        addTextChangedListener(binding.etPlantingDate) {
            gardenLogViewModel.onPlantingDateChanged(it)
        }
    }

    private fun addTextChangedListener(etView: EditText, onTextChanged: (String) -> Unit) {
        etView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChanged(s?.toString() ?: "")
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    private suspend fun onSaveClicked() {
        if (gardenLogViewModel.validatePlantData()) {
            gardenLogViewModel.savePlant()
            Snackbar.make(binding.root, "Plant added successfully", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, "Please fill all the fields", Snackbar.LENGTH_SHORT).show()
        }
    }

}