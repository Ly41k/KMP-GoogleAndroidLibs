package feature.more

import core.BaseNavigation
import navigation.NavigationTree

sealed class MoreNavigation(override val route: String) : BaseNavigation(route) {
    data object More : MoreNavigation(route = NavigationTree.More.More.name)
    data object Settings : MoreNavigation(route = NavigationTree.More.Settings.name)
}
