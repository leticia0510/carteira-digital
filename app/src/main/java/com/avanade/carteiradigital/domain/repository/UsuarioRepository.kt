package com.avanade.carteiradigital.domain.repository

import com.avanade.carteiradigital.domain.model.Usuario

interface UsuarioRepository {

    suspend fun criarUsuario(usuario: Usuario)

    suspend fun buscarUsuarioPorEmail(email: String): Usuario?

    suspend fun login(email: String, senha: String): Usuario?

    suspend fun getUsuarioPorId(id: String): Usuario?
}