package com.jagadeesh.thoughtworks

import com.jagadeesh.thoughtworks.modal.*
import com.jagadeesh.thoughtworks.network.WeatherService
import com.jagadeesh.thoughtworks.weatherdetails.WeatherDetailPresenter
import com.jagadeesh.thoughtworks.weatherdetails.IWeatherDetailView
import com.nhaarman.mockito_kotlin.*
import org.junit.Test
import org.junit.Before
import retrofit2.Retrofit
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
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
    private val weatherDetails = WeatherInfo(ArrayList(), Main(2.0,1,1,2.0,2.0), Wind(4.2,2.2),2,2, Clouds(2),
            "Test", Sys(1, 1, 1.1,"IN", 3, 3 ))


    @Before
    fun setup() {

        view = mock { }
        testSceduler = TestScheduler()

        weatherService = mock {
            on { getWeatherByCity(eq("Bangalore"), any()) } doReturn Observable.just(weatherDetails)}

        presenter = WeatherDetailPresenter(view, weatherService, testSceduler, testSceduler)
    }

    @Test
    fun shouldFetchWeather(){
        presenter.fetchWeatherData()
        verify(view).showLoader()
        verify(weatherService).getWeatherByCity(eq("Bangalore"), any())
        reset(view)
        testSceduler.triggerActions()
        verify(view).hideLoader()
        verify(view, times(1)).updateWeather(weatherDetails)
        verify(view, never()).showLoader()
    }

    @Test
    fun shouldHandleNetworkError(){

        val errorService: WeatherService = mock {
            on { getWeatherByCity(eq("Bangalore"), any()) } doReturn Observable.error(Exception())}

        presenter = WeatherDetailPresenter(view, errorService, testSceduler, testSceduler)
        presenter.fetchWeatherData()
        verify(view).showLoader()
        verify(errorService).getWeatherByCity(eq("Bangalore"), any())
        testSceduler.triggerActions()
        verify(view).hideLoader()
        verify(view).onError("error")
        verify(view, never()).showLoader()

    }

}
