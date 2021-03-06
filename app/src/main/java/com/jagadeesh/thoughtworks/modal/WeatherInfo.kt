package com.jagadeesh.thoughtworks.modal

/**
 * Created by jagadeesh on 05/05/18.
 */
data class WeatherInfo(
        val weather: List<Weather>,
        val main: Main,
        val wind: Wind,
        val dt: Int,
        val id: Int,
        val clouds: Clouds,
        val name: String,
        val sys: Sys
)

data class Wind(
        val speed: Double,
        val deg: Double
)

data class Clouds(
        val all: Int
)

data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)

data class Main(
        val temp: Double,
        val pressure: Int,
        val humidity: Int,
        val temp_min: Double,
        val temp_max: Double
)

data class Sys(
        val type: Int,
        val id: Int,
        val message: Double,
        val country: String,
        val sunrise: Int,
        val sunset: Int
)
