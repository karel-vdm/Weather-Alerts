package com.karel.weatheralerts.domain.model

data class WeatherAlertEntity(
    val id: String = String(),
    val eventName: String = String(),
    val startDate: String = String(),
    val endDate: String = String(),
    val source: String = String(),
)