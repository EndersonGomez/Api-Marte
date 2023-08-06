package com.example.apimarte.Model

import android.util.Log
import com.example.apimarte.Model.Local.MarsDao
import com.example.apimarte.Model.Remote.RetrofitClient

//Clase intermedia que expone los datos del model al ViewModel.
class Repository(private val marsDao: MarsDao) {

    //Instancia de retrofit.
    private val networkService = RetrofitClient.getRetrofit()

    //Variable que llama a la funcion que obtiene la lista de objetos de la base de datos.
    val marsListLiveData = marsDao.obtenerLista()

    //Funcion que llama los datos de la Api y los guarda en la base de datos.
    suspend fun TraerListaMars() {

        val service = kotlin.runCatching{ networkService.obtenerDatosApi()}

        service.onSuccess {

            when(it.code()){
                in 200 .. 299 -> it.body()?.let {
                    marsDao.agregarListaTerrenos(datosInternetParaLocal(it))
                }
                else -> Log.d("Prueba llamada a Api","${it.code()}--- ${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Prueba llamada a Api","${it.message}")
            }
        }
    }
}