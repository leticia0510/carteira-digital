package com.avanade.carteiradigital.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avanade.carteiradigital.domain.usecase.CadastroUseCase
import com.avanade.carteiradigital.presentation.effect.CadastroEffect
import com.avanade.carteiradigital.presentation.intent.CadastroIntent
import com.avanade.carteiradigital.presentation.uistate.CadastroUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CadastroViewModel(
    private val cadastroUseCase: CadastroUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CadastroUiState())
    val uiState = _uiState.asStateFlow()

    private val _effect = Channel<CadastroEffect>()
    val effect = _effect.receiveAsFlow()

    fun onIntent(intent: CadastroIntent) {

        when (intent) {

            is CadastroIntent.NomeChanged -> {
                _uiState.update {
                    it.copy(
                        nome = intent.nome,
                        erro = null
                    )
                }
            }

            is CadastroIntent.EmailChanged -> {
                _uiState.update {
                    it.copy(
                        email = intent.email,
                        erro = null
                    )
                }
            }

            is CadastroIntent.SenhaChanged -> {
                atualizarSenha(intent.senha)
            }

            is CadastroIntent.CadastroClicked -> {
                cadastrar()
            }

            is CadastroIntent.LoginClicked -> {
                enviarEffect(CadastroEffect.NavigateToLogin)
            }

            is CadastroIntent.VoltarClicked -> {
                enviarEffect(CadastroEffect.NavigateBack)
            }

            is CadastroIntent.ErrorShown -> {
                _uiState.update {
                    it.copy(erro = null)
                }
            }

            is CadastroIntent.CadastroSuccessHandled -> {
                _uiState.update {
                    it.copy(cadastroSucesso = false)
                }
            }
        }
    }

    private fun atualizarSenha(senha: String) {

        val maiuscula = senha.any { it.isUpperCase() }
        val minuscula = senha.any { it.isLowerCase() }
        val numero = senha.any { it.isDigit() }

        val especial = senha.any {
            !it.isLetterOrDigit() && !it.isWhitespace()
        }

        val valida = senha.length >= 8 &&
                maiuscula &&
                minuscula &&
                numero &&
                especial

        _uiState.update {
            it.copy(
                senha = senha,
                senhaTemMaiuscula = maiuscula,
                senhaTemMinuscula = minuscula,
                senhaTemNumero = numero,
                senhaTemCaractereEspecial = especial,
                senhaValida = valida,
                erro = null
            )
        }
    }

    private fun cadastrar() {

        val state = _uiState.value

        if (
            state.nome.isBlank() ||
            state.email.isBlank() ||
            state.senha.isBlank()
        ) {
            _uiState.update {
                it.copy(erro = "Preencha todos os campos")
            }
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS
                .matcher(state.email)
                .matches()
        ) {
            _uiState.update {
                it.copy(erro = "Digite um e-mail válido")
            }
            return
        }

        if (!state.senhaValida) {
            _uiState.update {
                it.copy(erro = "A senha não atende aos requisitos")
            }
            return
        }

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    erro = null
                )
            }

            try {

                cadastroUseCase(
                    nome = state.nome.trim(),
                    email = state.email.trim(),
                    senha = state.senha
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        cadastroSucesso = true
                    )
                }

                enviarEffect(CadastroEffect.CadastroSuccess)

            } catch (e: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        erro = "Não foi possível realizar o cadastro"
                    )
                }
            }
        }
    }

    private fun enviarEffect(effect: CadastroEffect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }
}