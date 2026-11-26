package com.avanade.carteiradigital.di

import com.avanade.carteiradigital.data.repository.UsuarioRepositoryImpl
import com.avanade.carteiradigital.domain.repository.UsuarioRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<UsuarioRepository> {
        UsuarioRepositoryImpl(
            get()
        )
    }

}