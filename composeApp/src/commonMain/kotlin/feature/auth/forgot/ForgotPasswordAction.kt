package feature.auth.forgot


sealed class ForgotPasswordAction {
    data object OpenRegistrationScreen : ForgotPasswordAction()
    data object Back : ForgotPasswordAction()
}
