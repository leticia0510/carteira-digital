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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.presentation.component.BotaoLaranja
import com.avanade.carteiradigital.presentation.component.LinkLaranja
import com.avanade.carteiradigital.ui.theme.Branco

@Composable
fun SplashScreen(navController: NavController) {
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
            DirecaoSplash()
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
fun DirecaoSplash() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = dimensionResource(id = R.dimen.spacing_extra_large))
    ) {
        BotaoLaranja(
            onClick = { /* Ação ao clicar no botão */ },
            modifier = Modifier,
            text = stringResource(id = R.string.comecar)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.spacing_medium))
        ) {
            Text(
                text = stringResource(id = R.string.ja_tem_uma_conta),
                color = Branco,
                fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
            )
            LinkLaranja(
                onClick = { /* Ação ao clicar no link */ },
                modifier = Modifier,
                text = stringResource(id = R.string.entrar)
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}
