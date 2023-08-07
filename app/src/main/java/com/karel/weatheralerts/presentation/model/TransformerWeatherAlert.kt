package com.karel.weatheralerts.presentation.model

import com.karel.weatheralerts.domain.model.WeatherAlertsEntity
import com.karel.weatheralerts.presentation.ISO8601DateFormatter.formatDate

fun WeatherAlertsEntity.transform() = WeatherAlerts(
    weatherAlerts = weatherAlerts.map {
        WeatherAlert(
            id = it.id,
            eventName = it.eventName,
            startDate = formatDate(it.startDate),
            endDate = formatDate(it.endDate),
            source = it.source,
        )
    }
)