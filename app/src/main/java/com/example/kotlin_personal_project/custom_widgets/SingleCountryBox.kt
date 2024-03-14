package com.example.kotlin_personal_project.custom_widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kotlin_personal_project.R
import com.example.kotlin_personal_project.viewmodel.Country
@Composable
fun SingleCountryBox(country: Country) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Image in the middle
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = country.flags.png,
                contentDescription = country.flags.alt,
                modifier = Modifier.size(200.dp, 200.dp),// Adjust the size of the image
            )
        }

        // Divider
        Divider(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            color = Color.Black
        )

        // Text content starting from left to right
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = stringResource(R.string.country_name, country.name.official))
            Text(text = stringResource(R.string.capital, country.capital[0]))
            if (country.unMember) {
                Text(text = stringResource(R.string.un_member))
            }
            Text(text = stringResource(R.string.region, country.region))
            Text(text = stringResource(R.string.area_km, country.area))
            Text(text = stringResource(R.string.population, country.population))
        }
    }
}
