package feature.home

import core.BaseNavigation
import navigation.NavigationTree

sealed class HomeNavigation(override val route: String) : BaseNavigation(route) {
    data object Home : HomeNavigation(route = NavigationTree.Home.Home.name)
    data object Details : HomeNavigation(route = NavigationTree.Home.Details.name)
}
