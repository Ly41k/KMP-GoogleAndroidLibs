package feature.auth.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import core.navigateToForgot
import core.navigateToRegister
import feature.auth.forgot.ForgotPasswordScreen
import feature.auth.login.LoginAction
import feature.auth.login.LoginScreen
import feature.auth.register.RegisterScreen

@Composable
fun AuthNavGraph(navAction: (AuthExternalAction) -> Unit) {
    val navigator = rememberNavController()
    NavHost(
        startDestination = AuthNavigation.Login.route,
        navController = navigator,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = AuthNavigation.Login.route) {
            LoginScreen(
                navAction = { loginAction ->
                    when (loginAction) {
                        LoginAction.OpenForgotScreen -> navigator.navigateToForgot()
                        LoginAction.OpenMainScreen -> navAction(AuthExternalAction.OpenMainScreen)
                        LoginAction.OpenRegistrationScreen -> navigator.navigateToRegister()
                    }
                }
            )
        }

        composable(route = AuthNavigation.Forgot.route) {
            ForgotPasswordScreen()
        }
        composable(route = AuthNavigation.Register.route) {
            RegisterScreen()
        }
    }
}
