package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.draganddrop.dragAndDropSource
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.presentation.component.CardTransacao
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.CinzaAzulado

@Composable
fun ExtratoScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Branco)
            .padding(dimensionResource(id = R.dimen.spacing_medium))
    ) {
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            Text(
                text = stringResource(id = R.string.extrato),
                fontSize = dimensionResource(id = R.dimen.text_size_2x_large).value.sp,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            BoxDeBusca()
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_small)),
                modifier = Modifier
                    .fillMaxWidth()
                ) {
                Box(
                    modifier = Modifier
                        .border(
                            width = dimensionResource(id = R.dimen.spacing_tiny),
                            color = CinzaAzulado,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_large))
                        )
                        .background(
                            Color.Black,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_large))
                        )
                        .padding(horizontal = dimensionResource(id = R.dimen.spacing_large), vertical = dimensionResource(id = R.dimen.spacing_medium)),
                ){
                    Text(
                        text = stringResource(id = R.string.todos),
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .border(
                            width = dimensionResource(id = R.dimen.spacing_tiny),
                            color = CinzaAzulado,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_large))
                        )
                        .background(
                            CinzaAzulado,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_large))
                        )
                        .padding(horizontal = dimensionResource(id = R.dimen.spacing_large), vertical = dimensionResource(id = R.dimen.spacing_medium)),
                ){
                    Text(
                        text = stringResource(id = R.string.entradas),
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .border(
                            width = dimensionResource(id = R.dimen.spacing_tiny),
                            color = CinzaAzulado,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_large))
                        )
                        .background(
                            CinzaAzulado,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_large))
                        )
                        .padding(horizontal = dimensionResource(id = R.dimen.spacing_large), vertical = dimensionResource(id = R.dimen.spacing_medium)),
                ){
                    Text(
                        text = stringResource(id = R.string.saidas),
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
                    )
                }
            }
        }
        item {
            Text(
                text = "Hoje",
                fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.spacing_large))
            )
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
fun BoxDeBusca(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lupa),
                        contentDescription = "Buscar",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size_medium))
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_small)))
                    Text(text = stringResource(id = R.string.buscar_transacoes))
                } },
            modifier = Modifier
                .border(
                    width = dimensionResource(id = R.dimen.spacing_tiny),
                    color = CinzaAzulado,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_medium))
                )
                .background(
                    CinzaAzulado,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_medium))
                )
                .weight(1f),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Button(
            onClick = { /* Ação ao clicar no botão */ },
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .width(58.dp)
                .height(58.dp)
                .background(
                    Color.Transparent),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            )
        ){
            Image(
                painter = painterResource(id = R.drawable.setting),
                contentDescription = "Filtro",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(dimensionResource(id = R.dimen.icon_size_semi_large))
            )
        }
    }
}

@Preview
@Composable
fun ExtratoScreenPreview() {
    ExtratoScreen()
}