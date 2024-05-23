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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import feature.home.HomeNavGraph
import feature.more.MoreNavGraph

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
                composable(route = MainNavigation.Home.route) { HomeNavGraph(logout = logout) }
                composable(route = MainNavigation.More.route) { MoreNavGraph(logout = logout) }
            }
        }
    }
}

@Composable
fun BottomNavigationUI(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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

            val items = getMainNavigationList()
            items.forEach {
                val isSelected = it.route == currentRoute
                NavigationBarItem(label = { Text(text = it.title, fontSize = 10.sp) },
                    selected = it.route == currentRoute,
                    icon = {
                        when (it) {
                            MainNavigation.Home,
                            MainNavigation.More -> TabItemIcon(it, isSelected)
                        }
                    },
                    colors = DefaultNavigationBarItemTheme(),
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.navigate(it.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    })
            }
        }
    }
}

private fun getMainNavigationList(): List<MainNavigation> = listOf(MainNavigation.Home, MainNavigation.More)

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
