package com.example.kotlin_personal_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlin_personal_project.pages.InfoPage
import com.example.kotlin_personal_project.pages.MainPage
import com.example.kotlin_personal_project.pages.SinglePage
import com.example.kotlin_personal_project.ui.theme.Kotlin_Personal_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_Personal_ProjectTheme {
                // A surface container using the 'background' color from the theme
                NavigationScaffoldApp()
            }
        }
    }
}

@Composable
fun NavigationScaffoldApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            MainPage(navController)
        }
        composable(
            route = "Info"
        ) {
            InfoPage(navController = navController)
        }
        composable(
            route = "Single/{country}", arguments = listOf(navArgument(name = "country") {
                type = NavType.StringType
            })
        ) { it ->
            it.arguments?.getString("country")?.let { it1 -> SinglePage(navController, it1) }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_Personal_ProjectTheme {
        NavigationScaffoldApp()
    }
}