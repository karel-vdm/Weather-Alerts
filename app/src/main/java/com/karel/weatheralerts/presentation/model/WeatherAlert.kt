package com.karel.weatheralerts.presentation.model

data class WeatherAlert(
    val id: String = String(),
    val eventName: String = String(),
    val startDate: String = String(),
    val endDate: String = String(),
    val source: String = String(),
) {
    val duration: String get() = "$startDate - $endDate"

}