package com.example.weatherappcourse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappcourse.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>() //для карточки с текущей погодой
    val liveDataList = MutableLiveData<List<WeatherModel>>() //для карточки с прогнозами на будущие дни
}