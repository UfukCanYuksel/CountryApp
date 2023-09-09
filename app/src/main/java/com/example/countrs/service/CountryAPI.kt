package com.example.countrs.service

import com.example.countrs.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    suspend fun getCountries() : Response<List<Country>>
}