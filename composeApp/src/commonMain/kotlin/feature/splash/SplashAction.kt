package feature.splash

sealed class SplashAction {
    data object OpenLoginScreen : SplashAction()
    data object OpenOnboardingScreen : SplashAction()
}
