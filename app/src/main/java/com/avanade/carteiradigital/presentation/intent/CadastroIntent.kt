package com.avanade.carteiradigital.presentation.intent

sealed interface CadastroIntent {

    data class NomeChanged(val nome: String) : CadastroIntent
    data class EmailChanged(val email: String) : CadastroIntent
    data class SenhaChanged(val senha: String) : CadastroIntent
    data object CadastroClicked : CadastroIntent
    data object VoltarClicked : CadastroIntent
    data object LoginClicked : CadastroIntent
    data object ErrorShown : CadastroIntent
    data object CadastroSuccessHandled : CadastroIntent
}