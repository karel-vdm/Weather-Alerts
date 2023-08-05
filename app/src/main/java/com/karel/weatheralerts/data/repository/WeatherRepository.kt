package com.karel.weatheralerts.data.repository

import com.karel.weatheralerts.data.api.model.WeatherAlertResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getAlerts(): Flow<WeatherAlertResponse>

}