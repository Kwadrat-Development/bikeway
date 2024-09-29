package io.bikeway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.bikeway.ui.Routes
import io.bikeway.ui.composables.NavBar
import io.bikeway.ui.screen.HomeScreen
import io.bikeway.ui.theme.BikewayTheme
import io.bikeway.ui.viewmodels.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BikewayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    Box(contentAlignment = Alignment.BottomCenter) {
                        App(navController, it)
                        NavBar(navController, modifier = Modifier.padding(it))
                    }
                }
            }
        }
    }
}

@Composable
fun App(navController: NavHostController, screenPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            val homeVM = remember {
                HomeViewModel(navController)
            }

            HomeScreen(homeVM, modifier = Modifier.padding(screenPadding))
        }
    }
}