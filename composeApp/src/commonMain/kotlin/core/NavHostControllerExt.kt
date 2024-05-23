package core

import androidx.navigation.NavHostController
import feature.auth.navigation.AuthNavigation
import navigation.AppNavigation

fun NavHostController.navigateToAuth() {
    this.popBackStack()
    this.navigate(AppNavigation.Auth.route) { launchSingleTop = true }
}

fun NavHostController.navigateToOnboading() {
    this.popBackStack()
    this.navigate(AppNavigation.Onboading.route) { launchSingleTop = true }
}

fun NavHostController.navigateToForgot() {
    this.navigate(AuthNavigation.Forgot.route)
}

fun NavHostController.navigateToRegister() {
    this.navigate(AuthNavigation.Register.route)
}


fun NavHostController.navigateToMain() {
    this.popBackStack()
    this.navigate(route = AppNavigation.Main.route) { launchSingleTop = true }
}

fun NavHostController.logout() {
    this.navigate(AppNavigation.Splash.route) { launchSingleTop = true }
}
