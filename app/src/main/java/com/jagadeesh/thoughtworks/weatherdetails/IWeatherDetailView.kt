package com.jagadeesh.thoughtworks.weatherdetails

import com.jagadeesh.thoughtworks.modal.WeatherInfo

/**
 * Created by jagadeesh on 05/05/18.
 */

interface IWeatherDetailView {
    fun updateWeather(weather: WeatherInfo)
    fun showLoader()
    fun hideLoader()
}