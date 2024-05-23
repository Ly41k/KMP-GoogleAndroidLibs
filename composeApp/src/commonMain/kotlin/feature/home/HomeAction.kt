package feature.home

sealed class HomeAction {
    data object OpenDetailsScreen : HomeAction()
}
