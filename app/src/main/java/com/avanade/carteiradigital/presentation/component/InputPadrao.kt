package com.avanade.carteiradigital.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.ui.theme.CinzaAzulado

@Composable
fun InputPadrao(
    label: String,
    placeholder: String,
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_small))
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = dimensionResource(id = R.dimen.spacing_tiny),
                    color = CinzaAzulado,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_medium))
                )
                .background(
                    Color.White.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_medium))
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}
