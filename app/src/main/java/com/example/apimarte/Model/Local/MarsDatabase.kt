package com.example.apimarte.Model.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Clase para la base de datos.
@Database(entities = [MarsEntity::class], version = 1, exportSchema = false)
abstract class MarsDatabase : RoomDatabase() {

    //Funcion para acceder al dao.
    abstract fun obtenerDao() : MarsDao

    //Codigo para poder crear la base de datos.
    companion object {

        @Volatile
        private var INSTANCE: MarsDatabase? = null

        fun getDataBase(context: Context): MarsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MarsDatabase::class.java, "mars_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}