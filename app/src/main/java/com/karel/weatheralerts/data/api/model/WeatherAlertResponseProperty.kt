package com.karel.weatheralerts.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherAlertResponseProperty(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("event")
    val event: String? = null,

    @SerializedName("effective")
    val effective: String? = null,

    @SerializedName("ends")
    val ends: String? = null,

    @SerializedName("senderName")
    val senderName: String? = null,

)