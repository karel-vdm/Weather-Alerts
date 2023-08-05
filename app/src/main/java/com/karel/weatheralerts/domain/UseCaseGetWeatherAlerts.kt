package com.karel.weatheralerts.domain

import com.karel.weatheralerts.data.repository.WeatherRepository
import com.karel.weatheralerts.domain.model.WeatherAlertsEntity
import com.karel.weatheralerts.domain.model.transform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UseCaseGetWeatherAlerts @Inject constructor(
    private val weatherRepository: WeatherRepository,
) {

    fun getAlerts(): Flow<WeatherAlertsEntity> = weatherRepository.getAlerts().map {
        it.transform()
    }

}