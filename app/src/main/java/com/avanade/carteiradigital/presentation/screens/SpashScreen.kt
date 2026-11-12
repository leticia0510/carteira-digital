package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.Laranja

@Composable
fun SplashScreen() {
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
                .padding(dimensionResource(id = R.dimen.vinte_quatro_dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_avanade),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.oitenta_dp))
            )
            Image(
                painter = painterResource(id = R.drawable.logo_nome_avanade),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 140.dp, height = 50.dp)
            )
            Text(
                text = stringResource(id = R.string.app_name),
                color = Branco,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.mais_controle),
                color = Branco,
                fontWeight = FontWeight.Light,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.cem_dp), horizontal = dimensionResource(id = R.dimen.setenta_dois_dp))
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Laranja
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dimensionResource(id = R.dimen.dezesseis_dp)),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.oito_dp)),

                    ) {
                    Text(
                        text = stringResource(id = R.string.comecar),
                        fontSize = 16.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.ja_tem_uma_conta),
                        color = Branco,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dezesseis_dp))
                    )
                    Text(
                        text = stringResource(id = R.string.entrar),
                        color = Laranja,
                        fontSize = 16.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.dezesseis_dp), start = dimensionResource(id = R.dimen.oito_dp))
                    )
                }
            }

        }
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
