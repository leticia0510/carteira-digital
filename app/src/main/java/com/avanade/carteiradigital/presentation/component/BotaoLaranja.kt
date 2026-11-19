package com.avanade.carteiradigital.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.avanade.carteiradigital.R
import com.avanade.carteiradigital.ui.theme.Laranja

@Composable
fun BotaoLaranja(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Laranja
        ),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.spacing_medium)),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.spacing_medium)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.spacing_small)),

        ) {
        Text(
            text = text,
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
        )
    }
}