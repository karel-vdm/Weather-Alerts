package com.karel.weatheralerts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.karel.weatheralerts.databinding.ActivityMainBinding
import com.karel.weatheralerts.presentation.model.WeatherAlerts
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var weatherAlertAdapter : WeatherAlertAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeView()
    }

    private fun initializeView() {
        initializeWeatherAlertList()
        viewModel.onCreate()
        viewModel.isLoading.observe(this) { isLoading ->
            showProgressIndicator(isLoading)
        }
        viewModel.error.observe(this) { error ->
            showError(error)
        }
        viewModel.weatherAlerts.observe(this){ weatherAlerts ->
            showWeatherAlerts(weatherAlerts)
        }
    }

    private fun showProgressIndicator(isVisible: Boolean) {
        binding.progressIndicator.isVisible = isVisible
    }

    private fun showError(error: String) {
        binding.errorMessage.isVisible = error.isNotEmpty()
        binding.errorMessage.text = error
    }

    private fun showWeatherAlerts(weatherAlerts: WeatherAlerts) {
        weatherAlertAdapter.addItems(weatherAlerts.weatherAlerts)
    }

    private fun initializeWeatherAlertList() {
        binding.weatherAlerts.layoutManager = LinearLayoutManager(this)
        weatherAlertAdapter = WeatherAlertAdapter()
        binding.weatherAlerts.adapter = weatherAlertAdapter
    }

}