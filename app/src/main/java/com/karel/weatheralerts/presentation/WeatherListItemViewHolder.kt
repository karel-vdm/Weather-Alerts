package com.karel.weatheralerts.presentation

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.karel.weatheralerts.R
import com.karel.weatheralerts.databinding.WeatherAlertItemBinding
import com.karel.weatheralerts.presentation.model.WeatherAlert

class WeatherListItemViewHolder(
    private val binding: WeatherAlertItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBindView(model: WeatherAlert) {
        binding.eventName.text = model.eventName
        binding.startDate.text = itemView.context.getString(R.string.start_date, model.startDate)
        binding.endDate.text = itemView.context.getString(R.string.end_date, model.endDate)
        binding.source.text = itemView.context.getString(R.string.source, model.source)
        binding.duration.text = itemView.context.getString(R.string.duration, model.duration)

        Glide.get(itemView.context).setMemoryCategory(MemoryCategory.LOW)
        Glide.with(itemView.context)
            .load(Uri.parse("https://picsum.photos/800?temp=${model.id}"))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.weatherAlertImage)
    }

}