package com.example.apimarte.Model

import com.example.apimarte.Model.Local.MarsEntity
import com.example.apimarte.Model.Remote.MarsRealstate

//Funcion para pasar los datos a la base de datos.
fun datosInternetParaLocal(lista: List<MarsRealstate>): List<MarsEntity> {

    return lista.map {

        MarsEntity(
            price = it.price,
            id = it.id,
            type = it.type,
            image = it.image
        )
    }
}