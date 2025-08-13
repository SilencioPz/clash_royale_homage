package com.example.clashzimdoscria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clashzimdoscria.ui.theme.ClashzimDosCriaTheme
import com.example.clashzimdoscria.ui.theme.screens.CasasScreen
import com.example.clashzimdoscria.ui.theme.screens.EstrategiasScreen
import com.example.clashzimdoscria.ui.theme.screens.MagiasScreen
import com.example.clashzimdoscria.ui.theme.screens.MenuScreen
import com.example.clashzimdoscria.ui.theme.screens.ModosScreen
import com.example.clashzimdoscria.ui.theme.screens.SobreScreen
import com.example.clashzimdoscria.ui.theme.screens.TropasScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClashzimDosCriaTheme {
                val navController = rememberNavController()
                Scaffold(
                    content = { innerPadding ->
                        NavigationHost(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") { MenuScreen(navController) }
        composable("tropas") { TropasScreen(navController) }
        composable("magias") { MagiasScreen(navController) }
        composable("casas") { CasasScreen(navController) }
        composable("modos") { ModosScreen(navController) }
        composable("estrategias") { EstrategiasScreen(navController) }
        composable("sobre") { SobreScreen(navController) }
    }
}