package com.example.kotlin_personal_project.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin_personal_project.custom_widgets.NavBar
import com.example.kotlin_personal_project.custom_widgets.SingleCountryBox
import com.example.kotlin_personal_project.viewmodel.CountriesUIState
import com.example.kotlin_personal_project.viewmodel.Country
import com.example.kotlin_personal_project.viewmodel.ViewModelCountry

@Composable

fun SinglePage(
    navController: NavController,
    name: String,
    countryViewModel: ViewModelCountry = viewModel()
) {
    Scaffold(
        topBar = { NavBar(title = name, navController = navController) },
        containerColor = Color.White
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            SingleCountryScreen(uiState = countryViewModel.countryUIState, name)
        }
    }
}


@Composable
fun SingleCountryScreen(uiState: CountriesUIState,name: String) {
    when (uiState) {
        is CountriesUIState.Loading -> LoadingScreen()
        is CountriesUIState.Success -> SingleCountry(uiState.countries, name)
        is CountriesUIState.Error -> ErrorScreen()
    }
}

@Composable
fun SingleCountry(countries: List<Country>, name: String) {
    countries.forEach { country ->
        if (country.name.official == name) {
            SingleCountryBox(country = country)
        }
    }
}