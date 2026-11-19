package com.avanade.carteiradigital.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.ui.theme.Laranja

@Composable
fun LinkLaranja(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
    Text(
        text = text,
        color = Laranja,
        fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        modifier = modifier
            .clickable(onClick = onClick)
    )
}