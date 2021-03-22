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
package com.novembergave.androiddevchallenge.data

import kotlin.random.Random

class WeatherRepository {

    fun getTodaysWeather(): Weather {
        val random = Random.Default
        val values = WEATHER.values()
        return with(values[random.nextInt(values.size)]) {
            Weather(
                temperature = temperature,
                weatherType = type
            )
        }
    }

    private enum class WEATHER(val temperature: Int, val type: WeatherType) {
        SUNNY(22, WeatherType.SUNNY),
        RAINY(18, WeatherType.RAINY),
        CLOUDY(20, WeatherType.CLOUDY)
    }
}
