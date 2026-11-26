package com.avanade.carteiradigital.data.repository

import com.avanade.carteiradigital.data.local.dao.UsuarioDao
import com.avanade.carteiradigital.data.local.entity.UsuarioEntity
import com.avanade.carteiradigital.domain.model.Usuario
import com.avanade.carteiradigital.domain.repository.UsuarioRepository

class UsuarioRepositoryImpl(
    private val usuarioDao: UsuarioDao
) : UsuarioRepository {

    override suspend fun criarUsuario(usuario: Usuario) {

        usuarioDao.criarUsuario(
            UsuarioEntity(
                id = usuario.id,
                nome = usuario.nome,
                email = usuario.email,
                senha = usuario.senha
            )
        )
    }

    override suspend fun buscarUsuarioPorEmail(email: String): Usuario? {

        return usuarioDao.buscarUsuarioPorEmail(email)?.let { entity ->

            Usuario(
                id = entity.id,
                nome = entity.nome,
                email = entity.email,
                senha = entity.senha
            )
        }
    }

    override suspend fun login(email: String, senha: String): Usuario? {

        return usuarioDao.login(email, senha)?.let { entity ->

            Usuario(
                id = entity.id,
                nome = entity.nome,
                email = entity.email,
                senha = entity.senha
            )
        }

    }

    override suspend fun getUsuarioPorId(id: String): Usuario? {

        return usuarioDao.getUsuarioPorId(id)?.let { entity ->

            Usuario(
                id = entity.id,
                nome = entity.nome,
                email = entity.email,
                senha = entity.senha
            )
        }
    }
}
