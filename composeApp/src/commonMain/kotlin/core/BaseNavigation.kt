package core

import androidx.navigation.NamedNavArgument

abstract class BaseNavigation(open val route: String, open val arguments: List<NamedNavArgument> = emptyList())
