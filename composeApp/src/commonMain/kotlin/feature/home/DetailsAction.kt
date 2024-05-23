package feature.home

sealed class DetailsAction {
    data object Back : DetailsAction()
    data object OpenSettingScreen : DetailsAction()
}
