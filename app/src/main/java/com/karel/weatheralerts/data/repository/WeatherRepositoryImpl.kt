package com.karel.weatheralerts.data.repository

import com.karel.weatheralerts.data.api.WeatherService
import com.karel.weatheralerts.data.api.model.WeatherAlertResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherRepository {

    override fun getAlerts(): Flow<WeatherAlertResponse> = flow {
        val status = "actual"
        val messageType = "alert"
        val result = weatherService.getAlerts(status, messageType)
        emit(result)
    }.flowOn(Dispatchers.IO)

}