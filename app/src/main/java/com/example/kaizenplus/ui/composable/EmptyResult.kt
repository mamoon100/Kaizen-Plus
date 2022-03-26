package com.example.kaizenplus.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kaizenplus.R

@Composable
fun EmptyResult() {
    Title(stringResource(id = R.string.no_result))
}