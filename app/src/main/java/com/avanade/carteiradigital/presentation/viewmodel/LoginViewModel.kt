package com.avanade.carteiradigital.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avanade.carteiradigital.domain.model.Usuario
import com.avanade.carteiradigital.domain.usecase.LoginUseCase
import com.avanade.carteiradigital.presentation.intent.LoginIntent
import com.avanade.carteiradigital.presentation.uistate.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()


    fun onIntent(intent: LoginIntent) {

        when(intent) {

            is LoginIntent.EmailChanged ->{
                _uiState.update {
                    it.copy(
                        email = intent.email,
                        erro = null
                    )
                }
            }

            is LoginIntent.SenhaChanged ->{
                _uiState.update {
                    it.copy(
                        senha = intent.senha,
                        erro = null
                    )
                }
            }

            is LoginIntent.LoginClicked ->{
                login()
            }

            is LoginIntent.ErrorShown ->{
                _uiState.update {
                    it.copy(
                        erro = null
                    )
                }
            }

            is LoginIntent.LoginSuccessHandled ->{
                _uiState.update {
                    it.copy(
                        loginSucesso = false
                    )
                }
            }
        }
    }

    private fun login() {

        val state = _uiState.value

        if(state.email.isBlank() || state.senha.isBlank()) {
            _uiState.update {
                it.copy(
                    erro = "Preencha todos os campos"
                )
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

                val usuario = loginUseCase(
                    email = state.email,
                    senha = state.senha
                )

                if(usuario != null){
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            loginSucesso = true
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            erro = "Usuário ou senha inválidos"
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        erro = "Ocorreu um erro ao realizar o login"
                    )
                }
            }
        }
    }

}