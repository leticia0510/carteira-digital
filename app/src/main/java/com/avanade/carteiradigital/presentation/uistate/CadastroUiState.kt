package com.avanade.carteiradigital.presentation.uistate

data class CadastroUiState(

    val nome: String = "",
    val email: String = "",
    val senha: String = "",
    val isLoading: Boolean = false,
    val cadastroSucesso: Boolean = false,
    val erro: String? = null,
    val senhaTemMaiuscula: Boolean = false,
    val senhaTemMinuscula: Boolean = false,
    val senhaTemNumero: Boolean = false,
    val senhaTemCaractereEspecial: Boolean = false,
    val senhaValida: Boolean = false

)