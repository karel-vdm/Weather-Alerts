package com.karel.weatheralerts.domain.model

import com.karel.weatheralerts.data.api.model.WeatherAlertResponse
import java.util.UUID

fun WeatherAlertResponse.transform() = WeatherAlertsEntity(
    weatherAlerts = features?.map {
        WeatherAlertEntity(
            id = it.properties?.id ?: UUID.randomUUID().toString(),
            eventName = it.properties?.event ?: "",
            startDate = it.properties?.effective ?: "",
            endDate = it.properties?.ends ?: "",
            source = it.properties?.senderName ?: "",
        )
    } ?: emptyList()
)