package com.jagadeesh.thoughtworks

import com.jagadeesh.thoughtworks.network.WeatherService
import com.jagadeesh.thoughtworks.weatherdetails.WeatherDetailPresenter
import com.jagadeesh.thoughtworks.weatherdetails.WeatherDetailView
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var presenter: WeatherDetailPresenter
    private lateinit var view: WeatherDetailView
    private lateinit var weatherService: WeatherService

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun setup(){

        view  = mock{ }
     //   weatherService = mock { on {getWeatherByCity("Coimbatore" ,""), any}}
        presenter = WeatherDetailPresenter(view)
    }

    @Test
    fun shouldFetchWeather(){

    }


}
