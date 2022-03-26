package com.example.kaizenplus.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.kaizenplus.R


@Composable
fun CustomDivider() {
    Divider(
        color = colorResource(id = R.color.light_purple),
        thickness = 1.dp,
        modifier = Modifier.padding(7.dp, 3.dp)
    )
}