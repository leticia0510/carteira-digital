package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.Screen
import com.avanade.carteiradigital.presentation.component.BotaoLaranja
import com.avanade.carteiradigital.presentation.component.InputPadrao
import com.avanade.carteiradigital.presentation.component.LinkLaranja
import com.avanade.carteiradigital.presentation.effect.CadastroEffect
import com.avanade.carteiradigital.presentation.intent.CadastroIntent
import com.avanade.carteiradigital.presentation.uistate.CadastroUiState
import com.avanade.carteiradigital.presentation.viewmodel.CadastroViewModel
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.CinzaAzulado
import org.koin.androidx.compose.koinViewModel

@Composable
fun CadastroScreen(
    navController: NavController
) {
    val cadastroViewModel: CadastroViewModel = koinViewModel()

    val uiState by cadastroViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {

        cadastroViewModel.effect.collect { effect ->

            when (effect) {

                CadastroEffect.NavigateToLogin -> {
                    navController.navigate(Screen.Login) {
                        popUpTo(Screen.Cadastro) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }

                CadastroEffect.NavigateBack -> {
                    navController.popBackStack()
                }

                CadastroEffect.CadastroSuccess -> {
                    navController.navigate(Screen.Login) {
                        popUpTo(Screen.Cadastro) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Branco)
            .padding(dimensionResource(id = R.dimen.spacing_medium))
    ) {
        item {
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(id = R.dimen.spacing_large)
                )
            )

            CabecalhoCadastro(
                onVoltarClick = {
                    cadastroViewModel.onIntent(
                        CadastroIntent.VoltarClicked
                    )
                }
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(id = R.dimen.spacing_extra_large)
                )
            )

            CadastroUsuario(
                uiState = uiState,
                onIntent = cadastroViewModel::onIntent
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(id = R.dimen.spacing_extra_large)
                )
            )

            LinkParaLogin(
                onLoginClick = {
                    cadastroViewModel.onIntent(
                        CadastroIntent.LoginClicked
                    )
                }
            )
        }
    }
}


@Composable
fun CabecalhoCadastro(
    onVoltarClick: () -> Unit
) {
    Column {

        IconButton(
            onClick = onVoltarClick
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Voltar"
            )
        }

        Spacer(
            modifier = Modifier.height(
                dimensionResource(id = R.dimen.spacing_large)
            )
        )

        Text(
            text = stringResource(R.string.criar_sua_conta),
            fontWeight = FontWeight.Bold,
            fontSize = dimensionResource(
                id = R.dimen.text_size_3x_large
            ).value.sp
        )

        Text(
            text = stringResource(R.string.e_rapido),
            fontSize = dimensionResource(
                id = R.dimen.text_size_large
            ).value.sp
        )
    }
}

@Composable
fun CadastroUsuario(
    uiState: CadastroUiState,
    onIntent: (CadastroIntent) -> Unit
) {

    InputPadrao(
        label = stringResource(R.string.nome_completo),
        modifier = Modifier,
        placeholder = stringResource(R.string.seu_nome),
        texto = uiState.nome,
        onValueChange = {
            onIntent(CadastroIntent.NomeChanged(it))
        }
    )

    Spacer(modifier = Modifier.height(16.dp))

    InputPadrao(
        label = stringResource(R.string.email),
        modifier = Modifier,
        placeholder = stringResource(R.string.seu_email),
        texto = uiState.email,
        onValueChange = {
            onIntent(CadastroIntent.EmailChanged(it))
        }
    )

    Spacer(modifier = Modifier.height(16.dp))

    InputPadrao(
        label = stringResource(R.string.senha),
        modifier = Modifier,
        placeholder = stringResource(R.string.minimo_8_caracteres),
        texto = uiState.senha,
        onValueChange = {
            onIntent(CadastroIntent.SenhaChanged(it))
        }
    )

    Spacer(modifier = Modifier.height(8.dp))

    Column {

        CheckSenha(
            texto = stringResource(R.string.letra_maiuscula),
            valido = uiState.senhaTemMaiuscula
        )

        CheckSenha(
            texto = stringResource(R.string.letra_minuscula),
            valido = uiState.senhaTemMinuscula
        )

        CheckSenha(
            texto = stringResource(R.string.numero),
            valido = uiState.senhaTemNumero
        )

        CheckSenha(
            texto = stringResource(R.string.caractere_especial),
            valido = uiState.senhaTemCaractereEspecial
        )
    }

    uiState.erro?.let {
        Text(
            text = it,
            color = Color.Red,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    BotaoLaranja(
        onClick = {
            onIntent(CadastroIntent.CadastroClicked)
        },
        modifier = Modifier,
        text = if (uiState.isLoading) {
            "Cadastrando..."
        } else {
            stringResource(R.string.cadastrar)
        }
    )
}

@Composable
fun CheckSenha(
    texto: String,
    valido: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {

        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = if (valido) Color(0xFF008000) else Color.Gray,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = texto,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp),
            color = if (valido) Color(0xFF008000) else Color.Gray
        )
    }
}

@Composable
fun LinkParaLogin(
    onLoginClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = stringResource(R.string.ja_tem_uma_conta),
            fontSize = dimensionResource(
                id = R.dimen.text_size_large
            ).value.sp
        )

        LinkLaranja(
            onClick = onLoginClick,
            modifier = Modifier,
            text = stringResource(R.string.entrar)
        )
    }
}

@Preview
@Composable
fun CadastroScreenPreview() {
    CadastroScreen(rememberNavController())
}