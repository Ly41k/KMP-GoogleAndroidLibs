package feature.splash

sealed class SplashAction {
    data object OpenLoginScreen : SplashAction()
}
