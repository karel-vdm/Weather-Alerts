package com.karel.weatheralerts.presentation

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.karel.weatheralerts.databinding.WeatherAlertItemBinding
import com.karel.weatheralerts.domain.model.WeatherAlertEntity

class WeatherListItemViewHolder(
    private val binding: WeatherAlertItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBindView(model: WeatherAlertEntity) {
        binding.eventName.text = model.eventName
        binding.startDate.text = model.startDate
        binding.endDate.text = model.endDate
        binding.source.text = model.source
        binding.duration.text = "${model.startDate} - ${model.endDate}"

        Glide.get(itemView.context).setMemoryCategory(MemoryCategory.LOW)
        Glide.with(itemView.context)
            .load(Uri.parse("https://picsum.photos/400?temp=${model.id}"))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .fitCenter()
            .into(binding.weatherAlertImage)
    }

}