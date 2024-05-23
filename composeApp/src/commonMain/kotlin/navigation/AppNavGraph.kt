package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import core.logout
import core.navigateToAuth
import core.navigateToForgot
import core.navigateToMain
import core.navigateToRegister
import feature.auth.forgot.ForgotPasswordAction
import feature.auth.forgot.ForgotPasswordScreen
import feature.auth.login.LoginAction
import feature.auth.login.LoginScreen
import feature.auth.register.RegisterAction
import feature.auth.register.RegisterScreen
import feature.main.MainNavGraph
import feature.splash.SplashAction
import feature.splash.SplashScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = NavigationTree.Splash.Splash.name,
            modifier = Modifier.fillMaxSize()
        ) {
            splashGraph(navController)
            authGraph(navController)
            composable(route = NavigationTree.Main.Dashboard.name) {
                MainNavGraph(logout = { navController.logout() })
            }
        }
    }
}

fun NavGraphBuilder.splashGraph(navController: NavHostController) {
    composable(route = NavigationTree.Splash.Splash.name) {
        SplashScreen(
            navAction = { navAction ->
                when (navAction) {
                    SplashAction.OpenLoginScreen -> navController.navigateToAuth()
                }
            }
        )
    }
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = NavigationTree.Auth.Login.name,
        route = NavigationTree.Auth.AuthFlow.name
    ) {
        composable(route = NavigationTree.Auth.Login.name) {
            LoginScreen(
                navAction = { loginAction ->
                    when (loginAction) {
                        LoginAction.OpenForgotScreen -> navController.navigateToForgot()
                        LoginAction.OpenMainScreen -> navController.navigateToMain()
                        LoginAction.OpenRegistrationScreen -> navController.navigateToRegister()
                    }
                }
            )
        }

        composable(route = NavigationTree.Auth.Forgot.name) {
            ForgotPasswordScreen(
                navAction = { forgotAction ->
                    when (forgotAction) {
                        ForgotPasswordAction.Back -> navController.popBackStack()
                        ForgotPasswordAction.OpenRegistrationScreen -> navController.navigateToRegister()
                    }
                }
            )
        }
        composable(route = NavigationTree.Auth.Register.name) {
            RegisterScreen(navAction = { registerAction ->
                when (registerAction) {
                    RegisterAction.Back -> navController.popBackStack()
                    RegisterAction.OpenForgotScreen -> navController.navigateToForgot()
                    RegisterAction.OpenMainScreen -> navController.navigateToMain()
                }
            })
        }
    }
}
