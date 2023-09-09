package com.example.countrs.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(

    @SerializedName("name") val countryName : String? ,
    @SerializedName("capital") val countryCapital : String? ,
    @SerializedName("region") val countryRegion : String? ,
    @SerializedName("currency") val countryCurrency : String? ,
    @SerializedName("flag") val imageUrl : String? ,
    @SerializedName("language") val countryLanguage : String?
): Serializable