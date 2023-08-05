package com.karel.weatheralerts

import com.karel.weatheralerts.data.api.model.WeatherAlertResponse
import com.karel.weatheralerts.data.api.model.WeatherAlertResponseFeature
import com.karel.weatheralerts.data.api.model.WeatherAlertResponseProperty
import com.karel.weatheralerts.data.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class WeatherRepositoryMock: WeatherRepository {

    override fun getAlerts(): Flow<WeatherAlertResponse> {
        return flow {
            emit(
                WeatherAlertResponse(
                    features = listOf(
                        WeatherAlertResponseFeature(
                            properties = WeatherAlertResponseProperty(
                                id = UUID.randomUUID().toString(),
                                event = "Severe Weather Event",
                                effective = "2023-03-26",
                                ends = "2024-03-26",
                                senderName = "NASA"
                            )
                        )
                    )
                )
            )
        }
    }

}