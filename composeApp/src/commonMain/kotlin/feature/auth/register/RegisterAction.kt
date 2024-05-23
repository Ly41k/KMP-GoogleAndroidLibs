package feature.auth.register


sealed class RegisterAction {
    data object OpenForgotScreen : RegisterAction()
    data object OpenMainScreen : RegisterAction()
    data object Back : RegisterAction()
}
