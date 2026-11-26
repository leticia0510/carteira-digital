package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.Screen
import com.avanade.carteiradigital.presentation.component.BotaoLaranja
import com.avanade.carteiradigital.presentation.component.LinkLaranja
import com.avanade.carteiradigital.presentation.intent.SplashIntent
import com.avanade.carteiradigital.presentation.viewmodel.SplashViewModel
import com.avanade.carteiradigital.ui.theme.Branco
import org.koin.androidx.compose.koinViewModel


@Composable
fun SplashScreen(
    navController: NavController
) {

    val splashViewModel: SplashViewModel = koinViewModel()

    val uiState by splashViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(
        uiState.navegarParaLogin,
        uiState.navegarParaComecar
    ) {

        when {
            uiState.navegarParaLogin -> {
                navController.navigate(Screen.Login) {
                    popUpTo(Screen.Splash) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }

                splashViewModel.onIntent(
                    SplashIntent.NavegacaoHandled
                )
            }

            uiState.navegarParaComecar -> {
                navController.navigate(Screen.Login) {
                    popUpTo(Screen.Splash) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }

                splashViewModel.onIntent(
                    SplashIntent.NavegacaoHandled
                )
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.tela_de_fundo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.spacing_large)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            IntroducaoSplash()

            DirecaoSplash(
                onComecarClick = {
                    splashViewModel.onIntent(
                        SplashIntent.ComecarClicked
                    )
                },
                onEntrarClick = {
                    splashViewModel.onIntent(
                        SplashIntent.EntrarClicked
                    )
                }
            )
        }
    }
}


@Composable
fun IntroducaoSplash() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_avanade),
            contentDescription = null,
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.spacing_3x_large))
        )
        Image(
            painter = painterResource(id = R.drawable.logo_nome_avanade),
            contentDescription = null,
            modifier = Modifier
                .size(
                    width = dimensionResource(id = R.dimen.logo_nome_avanade_width),
                    height = dimensionResource(id = R.dimen.logo_medium)
                )
        )
        Text(
            text = stringResource(id = R.string.app_name),
            color = Branco,
            fontSize = dimensionResource(id = R.dimen.text_size_4x_large).value.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.mais_controle),
            color = Branco,
            fontWeight = FontWeight.Light,
            fontSize = dimensionResource(id = R.dimen.text_size_2x_large).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.spacing_4x_large),
                    horizontal = dimensionResource(id = R.dimen.spacing_2x_large)
                )
        )
    }
}


@Composable
fun DirecaoSplash(
    onComecarClick: () -> Unit,
    onEntrarClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = dimensionResource(
                    id = R.dimen.spacing_extra_large
                )
            )
    ) {

        BotaoLaranja(
            onClick = onComecarClick,
            modifier = Modifier,
            text = stringResource(id = R.string.comecar)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.spacing_medium)
                )
        ) {

            Text(
                text = stringResource(id = R.string.ja_tem_uma_conta),
                color = Branco,
                fontSize = dimensionResource(
                    id = R.dimen.text_size_large
                ).value.sp
            )

            LinkLaranja(
                onClick = onEntrarClick,
                modifier = Modifier,
                text = stringResource(id = R.string.entrar)
            )
        }
    }
}

