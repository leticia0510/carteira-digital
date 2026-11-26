package com.avanade.carteiradigital.presentation.intent

sealed interface LoginIntent {

    data class EmailChanged(val email: String) : LoginIntent
    data class SenhaChanged(val senha: String) : LoginIntent

    data object LoginClicked : LoginIntent

    data object EsqueceuSenhaClicked : LoginIntent
    data object CadastroClicked : LoginIntent

    data object ErrorShown : LoginIntent
    data object LoginSuccessHandled : LoginIntent
}