package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.avanade.carteiradigital.presentation.component.CardTransacao
import com.avanade.carteiradigital.presentation.component.listaTransacoes
import com.avanade.carteiradigital.ui.theme.Azul
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.CinzaAzulado

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .background(Branco)
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.spacing_large))
    ) {
        item {
            CabecalhoHome()
        }
        item {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_medium)))
            BoxSaldo()
        }
        item {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_medium)))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotaoServico(
                    idImage = R.drawable.pix,
                    descricao = stringResource(id = R.string.area_pix),
                    nomeServico = stringResource(id = R.string.pix)
                )
                BotaoServico(
                    idImage = R.drawable.transacao,
                    descricao = stringResource(id = R.string.area_transferencia),
                    nomeServico = stringResource(id = R.string.transferir)
                )
                BotaoServico(
                    idImage = R.drawable.varredura,
                    descricao = stringResource(id = R.string.area_pagamento),
                    nomeServico = stringResource(id = R.string.pagar)
                )
                BotaoServico(
                    idImage = R.drawable.codigo_qr,
                    descricao = stringResource(id = R.string.qr_code),
                    nomeServico = stringResource(id = R.string.qr_code)
                )
            }
        }
        item {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_large)))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.ultimas_transacoes),
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
                )
                Text(
                    text = stringResource(id = R.string.ver_todas),
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                    color = Azul
                )
            }
            Column() {
                listaTransacoes.forEach { card ->
                    CardTransacao(
                        idImage = card.image,
                        descricao = card.description,
                        nomeServico = card.name,
                        data = card.date,
                        hora = card.hour,
                        valor = card.value
                    )
                }
            }
        }
    }
}

@Composable
fun BotaoServico(
    idImage: Int,
    descricao: String,
    nomeServico: String,
) {
    Box(
        modifier = Modifier
            .background(
                CinzaAzulado,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_small))
            )
            .width(dimensionResource(id = R.dimen.spacing_2x_large))
            .padding(vertical = dimensionResource(id = R.dimen.spacing_medium))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = descricao,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.spacing_large))
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_small)))
            Text(
                text = nomeServico,
                fontSize = dimensionResource(id = R.dimen.text_size_small).value.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun CabecalhoHome() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto_perfil_f),
            contentDescription = null,
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.spacing_medium))
                .size(dimensionResource(id = R.dimen.logo_medium))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.spacing_extra_large)))
        )
        Column() {
            Text(
                text = "Olá, Miranda!",
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
            )
            Text(text = stringResource(id = R.string.que_bom))
        }
    }
}

@Composable
fun BoxSaldo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                CinzaAzulado,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_small))
            )
            .padding(
                top = dimensionResource(id = R.dimen.spacing_medium),
                bottom = dimensionResource(id = R.dimen.spacing_extra_large),
                start = dimensionResource(id = R.dimen.spacing_medium),
                end = dimensionResource(id = R.dimen.spacing_medium)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.saldo_conta),
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
                )
                Text(
                    text = "R$ 100,00",
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_2x_large).value.sp
                )
            }
            Image(
                painter = painterResource(id = R.drawable.mostrar_senha),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.spacing_medium))
                    .size(dimensionResource(id = R.dimen.icon_size_large))
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}