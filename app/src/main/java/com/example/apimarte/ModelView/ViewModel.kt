package com.example.apimarte.ModelView

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.apimarte.Model.Local.MarsDatabase
import com.example.apimarte.Model.Local.MarsEntity
import com.example.apimarte.Model.Repository
import kotlinx.coroutines.launch

//Clase que expone los metodos a usar en la vista.
class ViewModel(application: Application) : AndroidViewModel(application) {

    //Variable que instancia al repositorio.
    private val repository: Repository

    init {
        val baseDeDato = MarsDatabase.getDataBase(application)
        val marsDao = baseDeDato.obtenerDao()

        repository = Repository(marsDao)

        viewModelScope.launch {
            repository.TraerListaMars()
        }
    }

    fun obtenerLista(): LiveData<List<MarsEntity>> = repository.marsListLiveData



}