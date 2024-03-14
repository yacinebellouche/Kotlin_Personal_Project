package com.example.kotlin_personal_project.custom_widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kotlin_personal_project.viewmodel.Country
import com.example.kotlin_personal_project.viewmodel.Flags

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCard(country: Country,onClick: ()->Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(5.dp),onClick = onClick, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            AsyncImage(
                modifier = Modifier.size(50.dp, 50.dp),
                model = country.flags.png,
                contentDescription = country.flags.alt
            )
            Text(modifier = Modifier.padding(horizontal = 5.dp),text = country.name.official, color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Bold, softWrap = true, fontSize = 14.sp)
        }
    }

}