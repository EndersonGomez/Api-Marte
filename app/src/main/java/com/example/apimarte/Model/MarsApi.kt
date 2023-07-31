package com.example.apimarte.Model

import retrofit2.http.GET
import retrofit2.Call

//Interface para llamar los datos de una api.
interface MarsApi {

    @GET("realestate")
    fun obtenerDatosApi(): Call<List<MarsRealstate>>

}