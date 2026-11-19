package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.presentation.component.BotaoLaranja
import com.avanade.carteiradigital.presentation.component.InputPadrao
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.BrancoAzulado

@Composable
fun RecuperarSenhaScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Branco)
            .padding(dimensionResource(id = R.dimen.spacing_medium))
    ) {
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Voltar",
            )
        }
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_2x_large)))
            BoxRecuperarSenha()
        }
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            DadosMaisVoltarRecuperarSenha()
        }
    }
}

@Composable
fun BoxRecuperarSenha() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.spacing_large)),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .background(
                    BrancoAzulado,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.icon_size_extra_large))
                )
                .padding((dimensionResource(id = R.dimen.spacing_extra_large)))
        ){
            Image(
                painter = painterResource(id = R.drawable.envelope),
                contentDescription = "Envenlope",
                modifier = Modifier.size(dimensionResource(id = R.dimen.logo_nome_avanade_height))
            )
        }
        Text(
            text = stringResource(id = R.string.recuperar_senha),
            fontSize = dimensionResource(id = R.dimen.text_size_3x_large).value.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.spacing_medium)),
        )
        Text(
            text = stringResource(id = R.string.informe_email),
            fontSize = dimensionResource(id = R.dimen.text_size_extra_large).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.spacing_medium)),
        )
    }
}

@Composable
fun DadosMaisVoltarRecuperarSenha() {
    Column() {
        InputPadrao(
            label = stringResource(id = R.string.email),
            modifier = Modifier,
            placeholder = stringResource(id = R.string.seu_email),
            value = "",
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
        BotaoLaranja(
            text = stringResource(id = R.string.enviar_instrucoes),
            onClick = {},
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
        Text(
            text = stringResource(id = R.string.voltar_para_login),
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(id = R.dimen.spacing_medium))
        )
    }
}

@Preview
@Composable
fun RecuperarSenhaScreenPreview() {
    RecuperarSenhaScreen()
}