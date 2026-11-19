package com.avanade.carteiradigital.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avanade.carteiradigital.R

@Composable
fun CardTransacao(
    idImage: Int,
    descricao: String,
    nomeServico: String,
    data: String,
    hora: String,
    valor: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.spacing_small))
    ) {
        Image(
            painter = painterResource(id = idImage),
            contentDescription = descricao,
            modifier = Modifier
                .background(
                    Color.Blue,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_extra_large))
                )
                .padding(dimensionResource(id = R.dimen.spacing_medium))
                .size(dimensionResource(id = R.dimen.spacing_large))
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_small)))
        Column() {
            Text(
                text = nomeServico,
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
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
            fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}