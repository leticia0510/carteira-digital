package com.avanade.carteiradigital.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.avanade.carteiradigital.presentation.screens.SplashScreen
import com.avanade.carteiradigital.presentation.viewmodel.LoginViewModel
import com.avanade.carteiradigital.presentation.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::SplashViewModel)
    viewModelOf(::LoginViewModel)

}