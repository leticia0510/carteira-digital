package com.avanade.carteiradigital.presentation.intent

sealed interface SplashIntent {
    data object ComecarClicked : SplashIntent
    data object EntrarClicked : SplashIntent
    data object NavegacaoHandled : SplashIntent
}