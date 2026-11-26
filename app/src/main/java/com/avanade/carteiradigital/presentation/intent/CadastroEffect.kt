package com.avanade.carteiradigital.presentation.effect

sealed interface CadastroEffect {

    data object NavigateToLogin : CadastroEffect
    data object NavigateBack : CadastroEffect
    data object CadastroSuccess : CadastroEffect

}