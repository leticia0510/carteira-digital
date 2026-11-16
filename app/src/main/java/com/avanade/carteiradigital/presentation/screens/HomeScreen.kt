package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.focus.focusModifier
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
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.CinzaAzulado

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .background(Branco)
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.vinte_quatro_dp))
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto_perfil_f),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = dimensionResource(id = R.dimen.dezesseis_dp))
                        .size(50.dp)
                        .clip(RoundedCornerShape(48.dp))
                )
                Column() {
                    Text(
                        text = "Olá, Miranda!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(text = stringResource(id = R.string.que_bom))
                }
            }
        }
        item {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.dezesseis_dp)))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            CinzaAzulado,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.oito_dp))
                        )
                        .padding(
                            top = dimensionResource(id = R.dimen.dezesseis_dp),
                            bottom = dimensionResource(id = R.dimen.trinta_dois_dp),
                            start = dimensionResource(id = R.dimen.dezesseis_dp),
                            end = dimensionResource(id = R.dimen.dezesseis_dp)
                        )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = stringResource(id = R.string.saldo_conta),
                                fontSize = 16.sp
                            )
                            Text(
                                text = "R$ 100,00",
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.mostrar_senha),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = dimensionResource(id = R.dimen.dezesseis_dp))
                                .size(30.dp)
                        )
                    }
                }
        }
        item {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.dezesseis_dp)))
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
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.vinte_quatro_dp)))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.ultimas_transacoes),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(id = R.string.ver_todas),
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            }
            Column() {
                CardTransacao(
                    idImage = R.drawable.icone_cart,
                    descricao = "Cart",
                    nomeServico = "Supermercado",
                    data = "Hoje",
                    hora = "10:24",
                    valor = "89,90"
                )
                CardTransacao(
                    idImage = R.drawable.icone_cart,
                    descricao = "Cart",
                    nomeServico = "Supermercado",
                    data = "Hoje",
                    hora = "10:24",
                    valor = "89,90"
                )
                CardTransacao(
                    idImage = R.drawable.icone_cart,
                    descricao = "Cart",
                    nomeServico = "Supermercado",
                    data = "Hoje",
                    hora = "10:24",
                    valor = "89,90"
                )
                CardTransacao(
                    idImage = R.drawable.icone_cart,
                    descricao = "Cart",
                    nomeServico = "Supermercado",
                    data = "Hoje",
                    hora = "10:24",
                    valor = "89,90"
                )
            }

        }
    }
}

@Composable
fun BotaoServico(
    idImage: Int,
    descricao: String,
    nomeServico: String,
){
    Box(
        modifier = Modifier
            .background(
                CinzaAzulado,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.oito_dp))
            )
            .width(dimensionResource(id = R.dimen.setenta_dois_dp))
            .padding(vertical = dimensionResource(id = R.dimen.dezesseis_dp))
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
                    .size(dimensionResource(id = R.dimen.vinte_quatro_dp))
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.oito_dp)))
            Text(
                text = nomeServico,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun CardTransacao(
    idImage: Int,
    descricao: String,
    nomeServico: String,
    data: String,
    hora: String,
    valor: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = idImage),
            contentDescription = descricao,
            modifier = Modifier
                .background(
                    Color.Blue,
                    shape = RoundedCornerShape(32.dp)
                )
                .padding(16.dp)
                .size(24.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                text = nomeServico,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row() {
                Text(
                    text = data
                )
                Text(
                    text = " - "
                )
                Text(
                    text = hora
                )
            }
        }
        Text(
            text = "- R$ $valor",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}