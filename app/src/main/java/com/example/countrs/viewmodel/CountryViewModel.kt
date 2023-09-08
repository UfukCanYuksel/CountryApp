package com.example.countrs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrs.model.Country

class CountryViewModel  :ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("Turkey" , "Ankara" , "Asia" ,"TL" , "ww.ss.com" , "Türkish")
        countryLiveData.value = country
    }
}