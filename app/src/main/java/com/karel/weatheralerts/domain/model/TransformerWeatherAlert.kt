package com.karel.weatheralerts.domain.model

import com.karel.weatheralerts.data.api.model.WeatherAlertResponse
import java.util.UUID

fun WeatherAlertResponse.transform() = WeatherAlertsEntity(
    weatherAlerts = features?.map {
        WeatherAlertEntity(
            id = it.properties?.id ?: UUID.randomUUID().toString(),
            eventName = it.properties?.event ?: String(),
            startDate = it.properties?.effective ?: String(),
            endDate = it.properties?.ends ?: String(),
            source = it.properties?.senderName ?: String(),
        )
    } ?: emptyList()
)