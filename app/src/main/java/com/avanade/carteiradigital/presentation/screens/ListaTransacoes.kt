package com.avanade.carteiradigital.presentation.component

import com.avanade.carteiradigital.R

data class Transacao(
    val image: Int,
    val description: String,
    val name: String,
    val date: String,
    val hour: String,
    val value: String
)

val listaTransacoes = listOf(
    Transacao(
        image = R.drawable.icone_cart,
        description = "Cart",
        name = "Supermercado",
        date = "Hoje",
        hour = "10:24",
        value = "89,90"
    ),
    Transacao(
        image = R.drawable.icone_cart,
        description = "Cart",
        name = "Supermercado",
        date = "Hoje",
        hour = "10:24",
        value = "89,90"
    ),
    Transacao(
        image = R.drawable.icone_cart,
        description = "Cart",
        name = "Supermercado",
        date = "Hoje",
        hour = "10:24",
        value = "89,90"
    ),
    Transacao(
        image = R.drawable.icone_cart,
        description = "Cart",
        name = "Supermercado",
        date = "Hoje",
        hour = "10:24",
        value = "89,90"
    )
)