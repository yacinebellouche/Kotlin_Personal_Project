package com.example.kotlin_personal_project.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin_personal_project.R
import com.example.kotlin_personal_project.custom_widgets.NavBar
import com.example.kotlin_personal_project.viewmodel.ViewModelCountry

@Composable

fun InfoPage(navController: NavController, countryViewModel: ViewModelCountry = viewModel()) {
    Scaffold(
        topBar = { NavBar(title = stringResource(R.string.info_page), navController = navController) },
        containerColor = Color.White
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column {
                Text(stringResource(R.string.info_page_content))

            }

        }
    }

}