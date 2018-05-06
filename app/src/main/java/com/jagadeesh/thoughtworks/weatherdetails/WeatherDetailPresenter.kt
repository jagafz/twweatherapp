package com.jagadeesh.thoughtworks.weatherdetails

import android.util.Log
import com.jagadeesh.thoughtworks.network.WeatherService
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by jagadeesh on 05/05/18.
 */

class WeatherDetailPresenter(private val view: IWeatherDetailView,
                             private val retrofitService: WeatherService = WeatherService.retrofitClient.instance(),
                             private val processScheduler: Scheduler = Schedulers.io(),
                             private val androidScheduler: Scheduler = AndroidSchedulers.mainThread()){
    fun fetchWeatherData() {
        view.showLoader()
        retrofitService.getWeatherByCity("Coimbatore")
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribe(
                        { weather ->
                            Log.i("Weather info" +"",weather.toString())
                            view.updateWeather(weather)
                            view.hideLoader()
                        }, { error -> Log.e("Weather info Failure",error.localizedMessage)
                            view.hideLoader()
                        })
    }
}

