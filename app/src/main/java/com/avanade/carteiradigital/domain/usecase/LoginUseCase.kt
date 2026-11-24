package com.avanade.carteiradigital.domain.usecase

import com.avanade.carteiradigital.domain.model.Usuario
import com.avanade.carteiradigital.domain.repository.UsuarioRepository

class LoginUseCase(
    private val repository: UsuarioRepository
) {

    suspend operator fun invoke(
        email: String,
        senha: String
    ): Usuario? {
        return repository.login(email, senha)
    }

}