package feature.more

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MoreNavGraph(logout: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        startDestination = MoreNavigation.More.route,
        navController = navController,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = MoreNavigation.More.route) {
            MoreScreen {
                when (it) {
                    MoreAction.OpenSettingScreen -> navController.navigate(MoreNavigation.Settings.route)
                }
            }
        }
        composable(route = MoreNavigation.Settings.route) {
            SettingScreen {
                when (it) {
                    SettingAction.Back -> navController.popBackStack()
                }
            }
        }
    }
}
