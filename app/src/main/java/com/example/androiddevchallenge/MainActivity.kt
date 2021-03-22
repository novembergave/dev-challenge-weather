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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.example.androiddevchallenge.data.WeatherUiModel
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<WeatherViewModel>()

        viewModel.viewState().observe(
            this,
            {
                setContent {
                    MyTheme {
                        WeatherApp(weatherUiModel = it)
                    }
                }
            }
        )
        viewModel.initialise(this)
    }
}

@Composable
fun WeatherApp(weatherUiModel: WeatherUiModel) {
    Surface(
        color = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background),
        modifier = Modifier
            .fillMaxSize()
    ) {
        WeatherUiData(weatherUiModel = weatherUiModel)
    }
}

@Composable
fun WeatherUiData(weatherUiModel: WeatherUiModel) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.surface,
                        Color.Transparent
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(weatherUiModel.weatherImageRes),
            contentDescription = weatherUiModel.weatherLabel,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .rotate(90f)
        )

        Text(
            text = weatherUiModel.temperature,
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp, 0.dp, 8.dp)
        )
        Text(
            text = weatherUiModel.weatherLabel,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                style = MaterialTheme.typography.body1,
                text = weatherUiModel.day,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Start
            )
            Text(
                style = MaterialTheme.typography.body1,
                text = weatherUiModel.time,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.End
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WeatherApp(
            WeatherUiModel(
                "Sunday",
                "13:41",
                R.drawable.ic_sunny,
                "WeatherLabel",
                "14 °C"
            )
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WeatherApp(
            WeatherUiModel(
                "Sunday",
                "13:41",
                R.drawable.ic_sunny,
                "WeatherLabel",
                "14 °C"
            )
        )
    }
}
