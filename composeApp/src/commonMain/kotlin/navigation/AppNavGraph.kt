package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import core.logout
import core.navigateToAuth
import core.navigateToMain
import core.navigateToOnboading
import feature.auth.navigation.AuthExternalAction
import feature.auth.navigation.AuthNavGraph
import feature.main.MainNavGraph
import feature.splash.SplashAction
import feature.splash.navigation.SplashNavGraph


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = AppNavigation.Splash.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(route = AppNavigation.Splash.route) {
                SplashNavGraph(
                    navAction = { navAction ->
                        when (navAction) {
                            SplashAction.OpenLoginScreen -> navController.navigateToAuth()
                            SplashAction.OpenOnboardingScreen -> navController.navigateToOnboading()
                        }
                    }
                )
            }
            composable(route = AppNavigation.Auth.route) {
                AuthNavGraph(
                    navAction = { navAction ->
                        when (navAction) {
                            AuthExternalAction.OpenMainScreen -> navController.navigateToMain()
                        }
                    }
                )
            }
            composable(route = AppNavigation.Main.route) {
                MainNavGraph(logout = { navController.logout() })
            }
        }
    }
}
