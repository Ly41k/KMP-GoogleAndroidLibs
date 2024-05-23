package feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import feature.home.DetailsAction
import feature.home.DetailsScreen
import feature.home.HomeAction
import feature.home.HomeScreen
import feature.more.MoreAction
import feature.more.MoreScreen
import feature.more.SettingAction
import feature.more.SettingScreen
import navigation.NavigationTree

@Composable
fun MainNavGraph(logout: () -> Unit) {
    val navBottomBarController = rememberNavController()

    Scaffold(bottomBar = { BottomNavigationUI(navBottomBarController) }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            NavHost(
                startDestination = MainNavigation.Home.route,
                navController = navBottomBarController,
                modifier = Modifier.fillMaxSize()
            ) {
                navigation(
                    startDestination = NavigationTree.Home.Home.name,
                    route = MainNavigation.Home.route
                ) {
                    composable(route = NavigationTree.Home.Home.name) {
                        HomeScreen {
                            when (it) {
                                HomeAction.OpenDetailsScreen -> navBottomBarController.navigate(NavigationTree.Home.Details.name)
                            }
                        }
                    }
                    composable(route = NavigationTree.Home.Details.name) {
                        DetailsScreen {
                            when (it) {
                                DetailsAction.Back -> navBottomBarController.popBackStack()
                                DetailsAction.OpenSettingScreen -> {
                                    navBottomBarController.navigate(NavigationTree.More.Settings.name)
                                }
                            }
                        }
                    }
                }

                navigation(
                    startDestination = NavigationTree.More.More.name,
                    route = MainNavigation.More.route
                ) {
                    composable(route = NavigationTree.More.More.name) {
                        MoreScreen {
                            when (it) {
                                MoreAction.OpenSettingScreen -> navBottomBarController.navigate(NavigationTree.More.Settings.name)
                            }
                        }
                    }
                    composable(route = NavigationTree.More.Settings.name) {
                        SettingScreen {
                            when (it) {
                                SettingAction.Back -> navBottomBarController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationUI(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Card(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp
        )
    ) {

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.background,
            tonalElevation = 8.dp
        ) {

            val items = listOf(MainNavigation.Home, MainNavigation.More)
            items.forEach { screen ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                NavigationBarItem(label = { Text(text = screen.title, fontSize = 10.sp) },
                    selected = isSelected,
                    icon = {
                        when (screen) {
                            MainNavigation.Home,
                            MainNavigation.More -> TabItemIcon(screen, isSelected)
                        }
                    },
                    colors = DefaultNavigationBarItemTheme(),
                    onClick = {
                        navController.navigate(screen.route) {
                            // Pop up to  the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().displayName) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    })
            }
        }
    }
}

@Composable
fun TabItemIcon(navItem: MainNavigation, isSelected: Boolean) {
    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = if (isSelected) navItem.selectedIcon else navItem.unselectedIcon,
        contentDescription = navItem.title
    )
}

@[Stable Composable]
fun DefaultNavigationBarItemTheme() = NavigationBarItemDefaults.colors(
    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
    unselectedIconColor = MaterialTheme.colorScheme.primary,
    unselectedTextColor = MaterialTheme.colorScheme.primary.copy(.9f),
    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
)
