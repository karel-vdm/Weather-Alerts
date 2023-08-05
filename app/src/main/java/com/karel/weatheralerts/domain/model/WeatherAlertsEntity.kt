package com.karel.weatheralerts.domain.model

data class WeatherAlertsEntity(
    val weatherAlerts: List<WeatherAlertEntity> = emptyList(),
)