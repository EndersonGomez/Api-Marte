package com.example.apimarte.Model.Local

import androidx.room.Entity
import androidx.room.PrimaryKey

//Clase para la tabla de la base de datos.
@Entity(tableName = "mars_table")
data class MarsEntity(

    //Atributos de la tabla.
    @PrimaryKey
    val id: String,
    val price: Long,
    val type: String,
    val image: String
)