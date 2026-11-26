package com.avanade.carteiradigital.di

import com.avanade.carteiradigital.domain.usecase.LoginUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {

    singleOf(::LoginUseCase)

}