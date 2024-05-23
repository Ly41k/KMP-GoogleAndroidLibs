package feature.auth.navigation

sealed class AuthExternalAction {
    data object OpenMainScreen : AuthExternalAction()
}
