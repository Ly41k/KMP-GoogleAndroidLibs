package feature.splash.navigation

import core.BaseNavigation
import navigation.NavigationTree

sealed class SplashNavigation(override val route: String) : BaseNavigation(route) {
    data object Splash : SplashNavigation(route = NavigationTree.Splash.Splash.name)
}
