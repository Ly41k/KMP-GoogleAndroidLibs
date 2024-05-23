package feature.auth.login

sealed class LoginAction {
    data object OpenRegistrationScreen : LoginAction()
    data object OpenForgotScreen : LoginAction()
    data object OpenMainScreen : LoginAction()
}
