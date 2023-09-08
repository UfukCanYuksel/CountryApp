package com.example.countrs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrs.model.Country

class FeedViewModel : ViewModel() {

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading =MutableLiveData<Boolean>()


    fun refreshData(){

        val country = Country("Turkey" , "Ankara" , "Asia" ,"TL" , "ww.ss.com" , "Türkish")
        val country2 = Country("Germany" , "Berlin" , "Europe" ,"EURO" , "ww.ss.com" , "German")
        val country3 = Country("France" , "Paris" , "Europe" ,"EURO" , "ww.ss.com" , "French")

        val countryList = arrayListOf<Country>(country , country2 , country3)
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false

    }
}