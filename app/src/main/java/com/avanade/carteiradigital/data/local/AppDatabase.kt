package com.avanade.carteiradigital.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.avanade.carteiradigital.data.local.dao.UsuarioDao
import com.avanade.carteiradigital.data.local.entity.UsuarioEntity


@Database(
    entities = [
        UsuarioEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object {
        const val DATABASE_NAME = "carteira_digital.db"
    }
}