package com.example.kaizenplus.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.kaizenplus.ui.composable.*
import com.example.kaizenplus.ui.theme.KaizenPlusTheme
import com.example.kaizenplus.viewModel.MainActivityViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainActivityViewModel by viewModels()
        setContent {
            val weathers = remember {
                viewModel.getWeather()
            }
            val searchResults = remember {
                viewModel.getSearchResults()
            }
            val (keyWord, setKeyWord) = remember {
                mutableStateOf("")
            }
            val (isSearching, setIsSearching) = remember {
                mutableStateOf(false)
            }
            val (isNotEmptyResults, setIsNotEmptyResults) = remember {
                mutableStateOf(false)
            }
            val keyboardController = LocalSoftwareKeyboardController.current
            val focusManager = LocalFocusManager.current
            val scope = rememberCoroutineScope()
            KaizenPlusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        Modifier.padding(20.dp, 0.dp),
                        verticalArrangement = Arrangement.spacedBy(50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Title()
                        SearchField(
                            keyWord,
                            {
                                setKeyWord(it)
                                setIsSearching(it.isNotEmpty())
                                viewModel.fetchResults(it)
                            },
                            {
                                setKeyWord("")
                            }
                        )
                        AnimatedVisibility(
                            visible = !isSearching,
                            enter = expandVertically(),
                            exit = shrinkVertically()
                        ) {
                            LazyColumn {
                                items(weathers.size) {
                                    WeatherCard(weatherDataResponseModel = weathers[it])
                                }
                            }
                        }
                        AnimatedVisibility(
                            visible = isSearching,
                            enter = expandVertically(),
                            exit = shrinkVertically()
                        ) {
                            setIsNotEmptyResults(
                                searchResults.value != null
                                        && searchResults.value!!.search_api != null
                                        && searchResults.value!!.search_api!!.result.isNotEmpty()
                            )
                            AnimatedVisibility(
                                visible = isNotEmptyResults,
                                enter = expandVertically(expandFrom = Alignment.CenterVertically),
                                exit = shrinkVertically()
                            ) {
                                LazyColumn(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    items(searchResults.value!!.search_api!!.result.size) { count ->
                                        SearchItem(
                                            result = searchResults.value!!.search_api!!.result[count],
                                            onClick = {
                                                scope.launch {
                                                    weathers.add(viewModel.fetchCityWeather(it))
                                                    setIsSearching(false)
                                                    keyboardController?.hide()
                                                    focusManager.clearFocus()
                                                }
                                            }
                                        )
                                    }
                                }
                            }
                            AnimatedVisibility(
                                visible = !isNotEmptyResults,
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                EmptyResult()
                            }
                        }
                    }
                }
            }
        }

    }
}
