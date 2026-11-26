package com.avanade.carteiradigital.presentation.effect

sealed interface LoginEffect {

    data object NavigateToCadastro : LoginEffect

    data object NavigateToRecuperarSenha : LoginEffect

}