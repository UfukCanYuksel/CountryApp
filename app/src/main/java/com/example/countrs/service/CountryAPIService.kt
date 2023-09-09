package com.example.countrs.service

import com.example.countrs.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CountryAPIService {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(CountryAPI::class.java)

    suspend fun getData() : Response<List<Country>> {
        return api.getCountries()
    }
}