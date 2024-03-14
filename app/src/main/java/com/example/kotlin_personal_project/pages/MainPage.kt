package com.example.kotlin_personal_project.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin_personal_project.custom_widgets.CountryCard
import com.example.kotlin_personal_project.custom_widgets.MainNavBar
import com.example.kotlin_personal_project.viewmodel.CountriesUIState
import com.example.kotlin_personal_project.viewmodel.Country
import com.example.kotlin_personal_project.viewmodel.ViewModelCountry


@Composable
fun MainPage(navController: NavController, countryViewModel: ViewModelCountry = viewModel()) {
    Scaffold(
        topBar = { MainNavBar(title = "Home Page", navController = navController) },
        containerColor = Color.White
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            CountryListScreen(uiState = countryViewModel.countryUIState, navController)
        }
    }
}

@Composable
fun CountryList(countries: List<Country>, navController: NavController) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(countries) { country ->
            CountryCard(
                country, onClick = { navController.navigate("Single/${country.name.official}") }
            )
            Divider()
        }
    }
}

@Composable
fun CountryListScreen(uiState: CountriesUIState, navController: NavController) {
    when (uiState) {
        is CountriesUIState.Loading -> LoadingScreen()
        is CountriesUIState.Success -> CountryList(uiState.countries, navController)
        is CountriesUIState.Error -> ErrorScreen()
    }
}


@Composable
fun LoadingScreen() {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen() {
    Text(text = "Error retrieving data from API.")
}



