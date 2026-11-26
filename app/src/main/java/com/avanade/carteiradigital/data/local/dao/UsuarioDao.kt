package com.avanade.carteiradigital.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avanade.carteiradigital.data.local.entity.UsuarioEntity

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun criarUsuario(usuario: UsuarioEntity)

    @Query("""
    SELECT * FROM usuarios 
    WHERE email = :email AND senha = :senha
""")
    suspend fun login(
        email: String,
        senha: String
    ): UsuarioEntity?

    @Query("SELECT * FROM usuarios WHERE id = :id")
    suspend fun getUsuarioPorId(id: String): UsuarioEntity?

}