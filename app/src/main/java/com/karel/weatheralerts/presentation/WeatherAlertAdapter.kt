package com.karel.weatheralerts.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.karel.weatheralerts.databinding.WeatherAlertItemBinding
import com.karel.weatheralerts.domain.model.WeatherAlertEntity

class WeatherAlertAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<WeatherAlertEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        /*return if (viewType == MOVIE) {*/
        val binding: WeatherAlertItemBinding = WeatherAlertItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherListItemViewHolder(binding)
        /*        } else {
                    val binding: MovieItemShimmerBinding = MovieItemShimmerBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    ViewHolderShimmer(binding)
                }*/
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /*    override fun getItemViewType(position: Int): Int {
            if (items[position].isInShimmerState) {
                return SHIMMER
            }
            return MOVIE
        }*/

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WeatherListItemViewHolder) {
            holder.onBindView(items[position])
        }
    }

    fun addItems(itemsToAdd: List<WeatherAlertEntity>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(items, itemsToAdd))
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(itemsToAdd)
        /*        if (!isLastPage && !isEmptyState) {
                    items.add(WeatherListItemViewHolder(isInShimmerState = true))
                }*/
    }

    private class DiffCallback(
        private val oldList: List<WeatherAlertEntity>,
        private val newList: List<WeatherAlertEntity>,
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