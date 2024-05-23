package feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import feature.more.MoreNavigation


@Composable
fun HomeNavGraph(logout: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        startDestination = HomeNavigation.Home.route,
        navController = navController,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = HomeNavigation.Home.route) {
            HomeScreen {
                when (it) {
                    HomeAction.OpenDetailsScreen -> navController.navigate(HomeNavigation.Details.route)
                }
            }
        }
        composable(route = HomeNavigation.Details.route) {
            DetailsScreen {
                when (it) {
                    DetailsAction.Back -> navController.popBackStack()
                    DetailsAction.OpenSettingScreen -> navController.navigate(MoreNavigation.Settings.route)
                }
            }
        }
    }
}
