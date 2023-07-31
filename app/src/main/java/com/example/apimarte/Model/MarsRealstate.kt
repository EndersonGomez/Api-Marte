package com.example.apimarte.Model

import com.google.gson.annotations.SerializedName

//Clase que tiene la estructura de los datos recibidos de la api.
data class MarsRealstate (

    @SerializedName("id")
    val id :String,
    @SerializedName("price")
    val price : Long,
    @SerializedName("type")
    val type : String,
    @SerializedName("img_src")
    val image: String
        )