package com.avanade.carteiradigital.di

import com.avanade.carteiradigital.domain.usecase.CadastroUseCase
import com.avanade.carteiradigital.domain.usecase.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory {
        LoginUseCase(
            repository = get()
        )
    }

    factory {
        CadastroUseCase(
            repository = get()
        )
    }
}