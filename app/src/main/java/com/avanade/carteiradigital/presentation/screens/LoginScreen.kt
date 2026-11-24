package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.sp
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.avanade.carteiradigital.presentation.intent.LoginIntent
import com.avanade.carteiradigital.presentation.viewmodel.LoginViewModel
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.CinzaAzulado
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navController: NavController
) {

    val loginViewModel: LoginViewModel = koinViewModel()

    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.loginSucesso) {

        if (uiState.loginSucesso){
            navController.navigate(Screen.Home) {

                popUpTo(Screen.Login) {
                    inclusive = true
                }

                launchSingleTop = true

                loginViewModel.onIntent(
                    LoginIntent.LoginSuccessHandled
                )
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
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            CabecalhoLogin()
        }
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))
            InputPadrao(
                label = stringResource(id = R.string.email),
                modifier = Modifier,
                placeholder = stringResource(id = R.string.email),
                texto = uiState.email,
                onValueChange = {
                    loginViewModel.onIntent(
                        LoginIntent.EmailChanged(it)
                    )
                }
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            InputPadrao(
                label = stringResource(id = R.string.senha),
                modifier = Modifier,
                placeholder = stringResource(id = R.string.senha),
                texto = uiState.senha,
                onValueChange = {
                    loginViewModel.onIntent(
                        LoginIntent.SenhaChanged(it)
                    )
                }
            )
            Text(
                text = stringResource(id = R.string.esqueceu_senha),
                fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.spacing_medium)),
                textAlign = TextAlign.End,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))
            BotaoLaranja(
                onClick = {
                    loginViewModel.onIntent(
                        LoginIntent.LoginClicked
                    )
                },
                modifier = Modifier,
                text = stringResource(id = R.string.entrar)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))
        }
        item {
            OutraOpcaoEntrada()
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))
            LinkParaCadastro()
        }
    }
}

@Composable
fun CabecalhoLogin() {
    Column() {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Voltar",
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))
        Text(
            text = stringResource(id = R.string.bem_vindo_volta),
            fontWeight = FontWeight.Bold,
            fontSize = dimensionResource(id = R.dimen.text_size_3x_large).value.sp,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_medium))
        )
        Text(
            text = stringResource(id = R.string.acesse_sua_conta),
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp
        )
    }
}

@Composable
fun OutraOpcaoEntrada() {
    Text(
        text = stringResource(id = R.string.ou),
        fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Button(
        onClick = { /* Ação ao clicar no botão */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = CinzaAzulado
        ),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.spacing_medium)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.spacing_medium)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_small)),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.biometria),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.spacing_small))
                    .size(dimensionResource(id = R.dimen.icon_size_large))
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_small)))
            Text(
                text = stringResource(id = R.string.entrar_com_biometria),
                fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun LinkParaCadastro() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.nao_tem_conta),
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp
        )
        LinkLaranja(
            onClick = { /* Ação ao clicar no link */ },
            modifier = Modifier,
            text = stringResource(id = R.string.cadastre_se)
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen( navController = rememberNavController() )

}
