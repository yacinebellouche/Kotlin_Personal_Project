package com.example.kotlin_personal_project.custom_widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.kotlin_personal_project.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MainNavBar(title: String, navController: NavController) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(title)
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.info_page_title)) },
                    onClick = { navController.navigate("Info") })
            }
        }
    )

}