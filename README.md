# CovDecem
![Kotlin 1.6.21](https://img.shields.io/badge/Kotlin-1.6.21-7F52FF?style=for-the-badge&logo=kotlin) ![Gradle 7.2](https://img.shields.io/badge/Gradle-7.2-02303A?style=for-the-badge&logo=gradle) ![Android Gradle Plugin 7.1.3](https://img.shields.io/badge/AGP-7.1.3-3DDC84?style=for-the-badge&logo=android)

CovDecem is an application that presents daily covid-19 situation data in Thailand. Based on the basics of AAC (Android Architecture Components) and Koin.

The objective of this project is to practice demonstrating sample data on applications and follow the best practices from Android development guideline.

<p align="center">
<br>
<img src="misc/covdecem-demo.gif" width="50%">
</p>

## Tech-stack
- Minimum Sdk level 24
- Tech-stack
  - Kotlin - based language
  - Coroutines - handle background operations
  - Jetpack 
    - LiveData - notify view about data change 
    - Lifecycle - act when lifecycle state changes 
    - ViewModel - store and manage data for UI-related with lifecycle aware 
    - Room - store offline cache 
    - Navigation - in-app navigation 
  - Koin - dependency injection 
  - Retrofit - construct type-safe HTTP for networking 
  - Moshi - modern JSON library for Android 
  - Timber - application debugging 
  - Localization - localizing library for Android
- UI
  - Material components - material design for UI
- Architecture
  - MVVM Architecture

## Open API
This project demonstrates covid-19 data from [link](https://static.easysunday.com/covid-19/getTodayCases.json?fbclid=IwAR32TkFaeuEX0uNHAFub_6bouqvVXkiixDNz63_cpeUovJr2HTAOTSVLkDQ).

## Acknowledge & Guideline
The relevant knowledge resources inspired and guided me in app development.

### Android Projects
- [android-showcase](https://github.com/igorwojda/android-showcase) - a sample project that demonstrates a modern Android development with popular libraries and best development practices.

### Course
- [Developing Android Apps with Kotlin](https://classroom.udacity.com/courses/ud9012) - Learn about the basics of modern android development.

## Upcoming improvements
- Create Unit tests
- Create UI tests

## License
This project is licensed under the [MIT](https://github.com/NoraHeithur/CovDecem/blob/main/LICENSE) license.