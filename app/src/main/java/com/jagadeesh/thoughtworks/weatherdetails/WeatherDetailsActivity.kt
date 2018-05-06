package com.jagadeesh.thoughtworks.weatherdetails

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jagadeesh.thoughtworks.R
import com.jagadeesh.thoughtworks.modal.WeatherInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IWeatherDetailView {
    private lateinit var presenter: WeatherDetailPresenter
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = WeatherDetailPresenter(this)
        presenter.fetchWeatherData()
    }

    override fun updateWeather(weather: WeatherInfo) {
        location.text = weather.name + ", "+ weather.sys.country
        temp.text = weather.main.temp.toString() + " Degree"
        humidity.text = weather.main.humidity.toString()
        pressure.text = weather.main.pressure.toString()
        wind.text = weather.wind.speed.toString()+"/"+weather.wind.deg
    }

    override fun onError(error: String) {
        Log.e("Weather info Failure",error)
    }

    override fun showLoader() {
        progressDialog = ProgressDialog(this, R.style.MyTheme)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setProgressStyle(android.R.style.Widget_ProgressBar_Large)
        progressDialog!!.show()
    }

    override fun hideLoader() {
        progressDialog!!.dismiss()
    }
}
