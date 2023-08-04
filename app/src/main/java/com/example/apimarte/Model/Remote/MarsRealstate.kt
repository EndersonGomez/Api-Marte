package com.example.apimarte.Model.Remote

import com.google.gson.annotations.SerializedName

//Clase que tiene la estructura de los datos recibidos de la api.
data class MarsRealstate (

    @SerializedName("price")
    val price : Long,
    @SerializedName("id")
    val id :String,
    @SerializedName("type")
    val type : String,
    @SerializedName("img_src")
    val image: String
        )