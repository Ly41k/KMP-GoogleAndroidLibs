package navigation

import core.BaseNavigation

sealed class AppNavigation(override val route: String) : BaseNavigation(route) {
    data object Splash : AppNavigation(route = NavigationTree.Splash.SplashFlow.name)
    data object Onboading : AppNavigation(route = NavigationTree.Onboarding.OnboardingFlow.name)
    data object Auth : AppNavigation(route = NavigationTree.Auth.AuthFlow.name)
    data object Main : AppNavigation(route = NavigationTree.Main.Dashboard.name)
}
