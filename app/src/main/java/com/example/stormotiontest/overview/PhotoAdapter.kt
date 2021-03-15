package com.example.stormotiontest.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stormotiontest.databinding.ViewItemBinding
import com.example.stormotiontest.network.Property

class PhotoAdapter(val onClickListener: OnClickListener):
ListAdapter<Property, PhotoAdapter.PropertyViewHolder>(DiffCallback){

    class PropertyViewHolder(private var binding: ViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(property: Property) {
            binding.property = property
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Property>() {
        override fun areItemsTheSame(oldItem: Property, newItem: Property): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Property, newItem: Property): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PropertyViewHolder {
        return PropertyViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(property)
        }
        holder.bind(property)
    }

    class OnClickListener(val clickListener: (property: Property) -> Unit) {
        fun onClick(property:Property) = clickListener(property)
    }
}