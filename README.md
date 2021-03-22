# Put title of your app here

<!--- Replace <OWNER> with your Github Username and <REPOSITORY> with the name of your repository. -->
<!--- You can find both of these in the url bar when you open your repository in github. -->
![Workflow result](https://github.com/novembergave/dev-challenge-weather/workflows/Check/badge.svg)


## :scroll: Description
Simple weather app using Jetpack Compose and MVVM


## :bulb: Motivation and Context
As I have not participated in the previous challenges this is pretty much my first attempt and lies on the simpler side.

This is a single screen application, with 3 possible UI states - Sunny, Rainy and Cloudy. The states are generated at random by the `WeatherRepository`. The `WeatherViewModel` translate this states to be ready for the UI.
The graphics for the weather as well as the app icon were inspired by Japanese Mons (emblems) and were created by myself for this challenge.

If I had more time, I would have liked to be able to:
- apply an animation to the weather icons, possibly a rotation one
- work out the theming a bit more: there appears to be some disconnect between the xml theme and the compose theme
- interactions: perhaps a refresh to trigger a new random state. At the moment it requires the user to close and restart.

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```