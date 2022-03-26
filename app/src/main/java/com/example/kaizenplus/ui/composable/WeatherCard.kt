package com.example.kaizenplus.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kaizenplus.model.WeatherDataResponseModel


@ExperimentalMaterial3Api
@Composable
fun WeatherCard(modifier: Modifier = Modifier,weatherDataResponseModel: WeatherDataResponseModel) {
    Card(
        containerColor = MaterialTheme.colorScheme.background,
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = weatherDataResponseModel.data.request!![0].query.split(",")[0],
                    fontSize = 16.sp,
                    maxLines = 1,
                )
                Text(
                    text = weatherDataResponseModel.data.current_condition[0].observation_time,
                    fontSize = 12.sp,
                    maxLines = 1,

                    )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${weatherDataResponseModel.data.current_condition[0].temp_C} C",
                    fontSize = 16.sp,
                    maxLines = 1,
                )
            }
        }
        CustomDivider()

    }
}