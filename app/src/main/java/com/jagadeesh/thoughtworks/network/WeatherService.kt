package com.jagadeesh.thoughtworks.network



import com.jagadeesh.thoughtworks.modal.WeatherInfo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by jagadeesh on 05/05/18.
 */
private const val APP_ID = "01ee1e4f614980940d1b5bc036ed24d2"
private const val URL = "http://api.openweathermap.org/data/"

interface WeatherService {

    @GET("2.5/weather")
    fun getWeatherByCity(@Query("q") query: String,
                             @Query("appid") appID: String = APP_ID)
                : Observable<WeatherInfo>

    object retrofitClient {
        private val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        private val weatherAPIService = retrofit.create(WeatherService::class.java)

        fun instance(): WeatherService = weatherAPIService
    }

}
