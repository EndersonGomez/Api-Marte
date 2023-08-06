package com.example.apimarte.Model.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Clase para crear una instancia de retrofit.
class RetrofitClient {

    companion object {

        //Variable que tiene la url base.
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

        //Funcion que crea la instancia de retrofit.
        fun getRetrofit(): MarsApi {
            //Creamos un objeto del tipo retrofif y lo configuramos.
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MarsApi::class.java)
        }
    }
}