package com.karel.weatheralerts.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherAlertResponseFeature(

    @SerializedName("properties")
    val properties: WeatherAlertResponseProperty? = null,

)