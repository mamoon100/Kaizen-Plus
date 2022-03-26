package com.example.kaizenplus.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.kaizenplus.model.Result

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    result: Result,
    onClick: (String) -> Unit
) {
    val areaName = result.areaName[0].value
    val country = result.country[0].value
    Text(
        text =
        "$areaName, $country",
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        modifier = modifier.clickable {
            onClick("$areaName  $country")
        }
    )
    CustomDivider()
}