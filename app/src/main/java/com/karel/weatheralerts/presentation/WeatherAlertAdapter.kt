package com.karel.weatheralerts.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.karel.weatheralerts.databinding.WeatherAlertItemBinding
import com.karel.weatheralerts.presentation.model.WeatherAlert

class WeatherAlertAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<WeatherAlert> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: WeatherAlertItemBinding = WeatherAlertItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherListItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WeatherListItemViewHolder) {
            holder.onBindView(items[position])
        }
    }

    fun addItems(itemsToAdd: List<WeatherAlert>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(items, itemsToAdd))
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(itemsToAdd)
    }

    private class DiffCallback(
        private val oldList: List<WeatherAlert>,
        private val newList: List<WeatherAlert>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val newItem = newList[newItemPosition]
            val oldItem = oldList[oldItemPosition]

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val newItem = newList[newItemPosition]
            val oldItem = oldList[oldItemPosition]

            return oldItem == newItem
        }
    }

}