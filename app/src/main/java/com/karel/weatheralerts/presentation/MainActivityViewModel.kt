package com.karel.weatheralerts.presentation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.karel.weatheralerts.domain.UseCaseGetWeatherAlerts
import androidx.lifecycle.viewModelScope
import com.karel.weatheralerts.domain.model.WeatherAlertsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val useCaseGetWeatherAlerts: UseCaseGetWeatherAlerts,
) : ViewModel() {

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private var _weatherAlerts = MutableLiveData<WeatherAlertsEntity>()
    val weatherAlerts: LiveData<WeatherAlertsEntity> get() = _weatherAlerts

    fun onCreate() {
        getWeatherAlerts()
    }

    private fun getWeatherAlerts() {
        viewModelScope.launch {
            useCaseGetWeatherAlerts.getAlerts()
                .onStart {
                    onLoadingWeatherAlerts()
                }
                .catch { exception ->
                    onGetWeatherAlertsError("Error getting weather alerts: ${exception.message}")
                }
                .collect { result ->
                    onGetWeatherAlertsComplete(result)
                }
        }
    }

    private fun onLoadingWeatherAlerts() {
        _isLoading.postValue(true)
    }

    private fun onGetWeatherAlertsError(error: String) {
        _isLoading.postValue(false)
        _error.postValue(error)
    }

    private fun onGetWeatherAlertsComplete(result: WeatherAlertsEntity) {
        _isLoading.postValue(false)
        _error.postValue("")
        _weatherAlerts.postValue(result)
    }

    @VisibleForTesting
    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

}