package core

import androidx.navigation.NavHostController
import navigation.NavigationTree

fun NavHostController.navigateToAuth() {
    this.popBackStack()
    this.navigate(NavigationTree.Auth.AuthFlow.name) { launchSingleTop = true }
}


fun NavHostController.navigateToForgot() {
    this.navigate(NavigationTree.Auth.Forgot.name)
}

fun NavHostController.navigateToRegister() {
    this.navigate(NavigationTree.Auth.Register.name)
}


fun NavHostController.navigateToMain() {
    this.popBackStack(route = NavigationTree.Auth.Login.name, inclusive = true)
    this.navigate(NavigationTree.Main.Dashboard.name) { launchSingleTop = true }
}

fun NavHostController.logout() {
    this.navigate(NavigationTree.Splash.Splash.name) { launchSingleTop = true }
}
