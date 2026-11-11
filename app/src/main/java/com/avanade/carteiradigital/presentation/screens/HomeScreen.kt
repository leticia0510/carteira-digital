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
import androidx.compose.ui.res.painterResource
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
            .padding(vertical = 24.dp, horizontal = 24.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto_perfil_f),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(50.dp)
                        .clip(RoundedCornerShape(50.dp))
                )
                Column() {
                    Text(
                        text = "Olá, Miranda!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(text = "Que bom te ver por aqui!")
                }
            }
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            CinzaAzulado,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = "Saldo da conta",
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
                                .padding(start = 16.dp)
                                .size(30.dp)
                        )
                    }
                }
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotaoServico(
                    idImage = R.drawable.pix,
                    descricao = "Área Pix",
                    nomeServico = "Pix"
                )
                BotaoServico(
                    idImage = R.drawable.transacao,
                    descricao = "Área Transação",
                    nomeServico = "Transferir"
                )
                BotaoServico(
                    idImage = R.drawable.varredura,
                    descricao = "Área de pagamento",
                    nomeServico = "Pgar"
                )
                BotaoServico(
                    idImage = R.drawable.codigo_qr,
                    descricao = "QR Code",
                    nomeServico = "QR Code"
                )
            }
        }
        item {
            Spacer(modifier = Modifier.size(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Últimas transações",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Ver todas",
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
                shape = RoundedCornerShape(16.dp)
            )
            .width(72.dp)
            .padding(vertical = 16.dp)
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
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
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