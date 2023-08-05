package com.karel.weatheralerts.data.api

import com.karel.weatheralerts.data.api.model.WeatherAlertResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    //
    // https://api.weather.gov/alerts/active?status=actual&message_type=alert
    //
    @GET("alerts/active")
    suspend fun getAlerts(
        @Query("status") status: String,
        @Query("message_type") messageType: String
    ): WeatherAlertResponse

}