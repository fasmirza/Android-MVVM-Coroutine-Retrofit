package com.temotion.mirzas.datafetchingmvvmhiltretro.Network


import com.temotion.mirzas.datafetchingmvvmhiltretro.Models.CountryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query : String): CountryModel
}