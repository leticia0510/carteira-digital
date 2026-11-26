package com.avanade.carteiradigital.domain.usecase

import com.avanade.carteiradigital.domain.model.Usuario
import com.avanade.carteiradigital.domain.repository.UsuarioRepository

class CadastroUseCase(
    private val repository: UsuarioRepository
) {

    suspend operator fun invoke(
        nome: String,
        email: String,
        senha: String
    ) {
        val usuario = Usuario(
            id = java.util.UUID.randomUUID().toString(),
            nome = nome,
            email = email,
            senha = senha
        )

        repository.criarUsuario(usuario)
    }
}