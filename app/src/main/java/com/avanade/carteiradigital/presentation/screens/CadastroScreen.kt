package com.avanade.carteiradigital.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.presentation.component.BotaoLaranja
import com.avanade.carteiradigital.presentation.component.InputPadrao
import com.avanade.carteiradigital.presentation.component.LinkLaranja
import com.avanade.carteiradigital.ui.theme.Branco
import com.avanade.carteiradigital.ui.theme.CinzaAzulado

@Composable
fun CadastroScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Branco)
            .padding(dimensionResource(id = R.dimen.spacing_medium))
    ) {
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            CabecalhoCadastro()
        }
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))
            CadastroUsuario()
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))
        }
        item {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))
            LinkParaLogin()
        }
    }
}


@Composable
fun CabecalhoCadastro() {
    Column() {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Voltar",
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
        Text(
            text = stringResource(id = R.string.criar_sua_conta),
            fontWeight = FontWeight.Bold,
            fontSize = dimensionResource(id = R.dimen.text_size_3x_large).value.sp,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_medium))
        )
        Text(
            text = stringResource(id = R.string.e_rapido),
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp
        )
    }
}

@Composable
fun CadastroUsuario() {
    InputPadrao(
        label = stringResource(id = R.string.nome_completo),
        modifier = Modifier,
        placeholder = stringResource(id = R.string.seu_nome),
        value = "",
        onValueChange = {}
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
    InputPadrao(
        label = stringResource(id = R.string.email),
        modifier = Modifier,
        placeholder = stringResource(id = R.string.seu_email),
        value = "",
        onValueChange = {}
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
    InputPadrao(
        label = stringResource(id = R.string.senha),
        modifier = Modifier,
        placeholder = stringResource(id = R.string.minimo_8_caracteres),
        value = "",
        onValueChange = {}
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))
    Box(){
        Column() {
            CheckSenha(
                texto = stringResource(id = R.string.letra_maiuscula)
            )
            CheckSenha(
                texto = stringResource(id = R.string.letra_minuscula)
            )
            CheckSenha(
                texto = stringResource(id = R.string.numero)
            )
            CheckSenha(
                texto = stringResource(id = R.string.caractere_especial)
            )
        }
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))
    BotaoLaranja(
        onClick = { /* Ação ao clicar no botão */ },
        modifier = Modifier,
        text = stringResource(id = R.string.cadastrar)
    )
}

@Composable
fun CheckSenha(
    texto: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = dimensionResource(id = R.dimen.spacing_small))
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Confirmar",
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = texto,
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.spacing_small)),
        )
    }
}

@Composable
fun LinkParaLogin() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.ja_tem_uma_conta),
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp
        )
        LinkLaranja(
            onClick = { /* Ação ao clicar no link */ },
            modifier = Modifier,
            text = stringResource(id = R.string.entrar)
        )
    }
}
@Preview
@Composable
fun CadastroScreenPreview() {
    CadastroScreen()
}