package com.madhavth.gardeningjournalapp.features.home.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import com.madhavth.gardeningjournalapp.databinding.ItemPlantBinding

class PlantsAdapter(private val onPlantClicked: (Plant)-> Unit) : ListAdapter<Plant, PlantsAdapter.ItemViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(
            binding,
            onPlantClicked
        )
    }

    override fun onBindViewHolder(holder: PlantsAdapter.ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(private val itemBinding: ItemPlantBinding, val onClick: (Plant) -> Unit) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Plant) {
            itemBinding.tvPlantName.text = item.name
            itemBinding.root.setOnClickListener {
                onClick(item)
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}