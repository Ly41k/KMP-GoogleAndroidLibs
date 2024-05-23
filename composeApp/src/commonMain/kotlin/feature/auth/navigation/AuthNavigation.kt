package feature.auth.navigation

import core.BaseNavigation
import navigation.NavigationTree

sealed class AuthNavigation(override val route: String) : BaseNavigation(route) {
    data object Login : AuthNavigation(route = NavigationTree.Auth.Login.name)
    data object Register : AuthNavigation(route = NavigationTree.Auth.Register.name)
    data object Forgot : AuthNavigation(route = NavigationTree.Auth.Forgot.name)
}
