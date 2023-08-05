package com.karel.weatheralerts.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherAlertResponse(

    @SerializedName("features")
    val features: List<WeatherAlertResponseFeature>? = null,

)