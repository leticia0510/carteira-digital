package com.avanade.carteiradigital

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.avanade.carteiradigital.presentation.screens.CadastroScreen
import com.avanade.carteiradigital.presentation.screens.ExtratoScreen
import com.avanade.carteiradigital.presentation.screens.HomeScreen
import com.avanade.carteiradigital.presentation.screens.LoginScreen
import kotlinx.serialization.Serializable
import kotlin.collections.forEach

data class BottomNavItem<T : Any>(
    val route: T,
    val icon: ImageVector,
    val label: String
)

@Serializable
sealed class Screen{

    @Serializable
    object Login : Screen()

    @Serializable
    object Cadastro : Screen()

    @Serializable
    object Home : Screen()

    @Serializable
    object Extrato : Screen()

}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val buttomNavItems = listOf(
        BottomNavItem(
            Screen.Home,
            Icons.Default.Home,
            "Home"
        ),
        BottomNavItem(
            Screen.Extrato,
            Icons.Default.Book,
            "Extrato"
        )
    )

    val showBottomBar =
        currentDestination?.hierarchy?.any {
            it.hasRoute(Screen.Home::class) ||
                    it.hasRoute(Screen.Extrato::class)
        } == true

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigatorItem(navController, buttomNavItems)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<Screen.Login> {
                LoginScreen()
            }

            composable<Screen.Cadastro> {
                CadastroScreen()
            }

            composable<Screen.Home> {
                HomeScreen()
            }

            composable<Screen.Extrato> {
                ExtratoScreen()
            }

        }

    }

}


@Composable
fun BottomNavigatorItem(navController: NavController, itens: List<BottomNavItem<out Any>>){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        itens.forEach { item ->
            val isSelected =
                currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}