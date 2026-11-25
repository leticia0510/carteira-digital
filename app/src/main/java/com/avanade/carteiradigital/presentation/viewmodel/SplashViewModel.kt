package com.avanade.carteiradigital.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.avanade.carteiradigital.presentation.intent.SplashIntent
import com.avanade.carteiradigital.presentation.uistate.SplashUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SplashViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SplashUiState())
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    fun onIntent(intent: SplashIntent) {

        when (intent) {

            is SplashIntent.ComecarClicked -> {
                _uiState.update {
                    it.copy(navegarParaComecar = true)
                }
            }

            is SplashIntent.EntrarClicked -> {
                _uiState.update {
                    it.copy(navegarParaLogin = true)
                }
            }

            is SplashIntent.NavegacaoHandled -> {
                _uiState.update {
                    it.copy(
                        navegarParaLogin = false,
                        navegarParaComecar = false
                    )
                }
            }
        }
    }
}
