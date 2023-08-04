package com.example.apimarte.Model.Local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

//Interfaz que tiene los metodos para manejar la base de datos.
@Dao
interface MarsDao {

    //Funcion que agregara los datos a la base de datos.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarListaTerrenos(terrenos: List<MarsEntity>)

    //Funcion que llama a la lista de la base de datos por orden de id.
    @Query("SELECT * FROM MARS_TABLE ORDER BY id ASC")
    fun obtenerLista (): LiveData<List<MarsEntity>>

    //Funcion para acceder a un campo por id de la base de datos.
    @Query("SELECT * FROM MARS_TABLE WHERE id = :id")
    fun buscarPorId(id : String): LiveData<MarsEntity>

}