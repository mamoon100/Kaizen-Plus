package com.example.kaizenplus.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kaizenplus.R


@Composable
fun Title(title: String = LocalContext.current.getString(R.string.title)) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 24.dp, 0.dp, 0.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,

        )
}