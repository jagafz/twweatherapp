package com.jagadeesh.thoughtworks

import com.jagadeesh.thoughtworks.modal.*
import com.jagadeesh.thoughtworks.network.WeatherService
import com.jagadeesh.thoughtworks.weatherdetails.WeatherDetailPresenter
import com.jagadeesh.thoughtworks.weatherdetails.IWeatherDetailView
import com.nhaarman.mockito_kotlin.*
import org.junit.Test
import org.junit.Before
import rx.Observable
import rx.schedulers.TestScheduler

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var presenter: WeatherDetailPresenter
    private lateinit var view: IWeatherDetailView
    private lateinit var weatherService: WeatherService
    lateinit var testSceduler: TestScheduler
   // private val weatherInfo = WeatherInfo(ArrayList(), Main(2.0,1,1,2.0,2.0), Wind(2.0,1.0), 1, 1, Clouds(2), Sys(1, 1, 2.4,"hello",1619,119))

    @Before
    fun setup() {

        view = mock { }
        testSceduler = TestScheduler()

//        weatherService = mock {
//            on { getWeatherByCity(eq("Bangalore"), any()) } doReturn Observable.just(weatherInfo)}
//
//        presenter = WeatherDetailPresenter(view, weatherService, testSceduler, testSceduler)
    }

    @Test
    fun shouldFetchWeather(){

        presenter.fetchWeatherData()
        verify(view).showLoader()
 //       verify(weatherService).getWeatherByCity(eq("Bangalore"), any())


    }

}
