/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.WeatherRepository
import com.example.androiddevchallenge.data.WeatherType
import com.example.androiddevchallenge.data.WeatherUiModel
import java.text.DateFormat.getDateInstance
import java.text.DateFormat.getTimeInstance
import java.util.Calendar

class WeatherViewModel : ViewModel() {

    private val weatherRepository = WeatherRepository()

    private val viewState: MutableLiveData<WeatherUiModel> = MutableLiveData()

    fun viewState(): LiveData<WeatherUiModel> = viewState

    fun initialise(context: Context) { // wouldn't normally pass context but makes no sense to add DI
        val c: Calendar = Calendar.getInstance()
        val time = getTimeInstance().format(c.time)
        val date = getDateInstance().format(c.time)
        val weather = weatherRepository.getTodaysWeather()
        viewState.postValue(
            WeatherUiModel(
                day = date,
                time = time,
                weatherImageRes = when (weather.weatherType) {
                    WeatherType.SUNNY -> R.drawable.ic_sunny
                    WeatherType.RAINY -> R.drawable.ic_rainy
                    WeatherType.CLOUDY -> R.drawable.ic_cloudy
                },
                weatherLabel = context.getString(
                    when (weather.weatherType) {
                        WeatherType.SUNNY -> R.string.sunny
                        WeatherType.RAINY -> R.string.rainy
                        WeatherType.CLOUDY -> R.string.cloudy
                    }
                ),
                temperature = context.getString(
                    R.string.degrees_celsius,
                    weather.temperature
                )
            )
        )
    }
}
