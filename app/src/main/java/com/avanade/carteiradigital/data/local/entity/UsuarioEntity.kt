package com.avanade.carteiradigital.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class UsuarioEntity (
    @PrimaryKey
    val id: String,
    val nome: String,
    val email: String,
    val senha: String
)