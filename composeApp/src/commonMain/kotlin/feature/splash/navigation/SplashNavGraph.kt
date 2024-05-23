package feature.splash.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import feature.splash.SplashAction
import feature.splash.SplashScreen

@Composable
fun SplashNavGraph(navAction: (SplashAction) -> Unit) {
    val navigator = rememberNavController()
    NavHost(
        startDestination = SplashNavigation.Splash.route,
        navController = navigator,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = SplashNavigation.Splash.route) { SplashScreen(navAction) }
    }
}

