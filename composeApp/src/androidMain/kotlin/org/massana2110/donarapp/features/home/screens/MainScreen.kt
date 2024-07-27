package org.massana2110.donarapp.features.home.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.massana2110.donarapp.navigation.DonarBottomAppBar
import org.massana2110.donarapp.navigation.graphs.MainNavGraph

@Composable
fun MainScreen(
    rootNavHostController: NavHostController,
    homeNavHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            val navBackStackEntry by homeNavHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination

            DonarBottomAppBar(currentDestination = currentRoute) {
                homeNavHostController.navigate(it.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(homeNavHostController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        }
    ) {
        MainNavGraph(
            rootNavHostController = rootNavHostController,
            homeNavHostController = homeNavHostController,
            innerPaddingValues = it
        )
    }
}

@Preview
@Composable
private fun MainScreenPrev() {
    MaterialTheme {
        MainScreen(
            rootNavHostController = rememberNavController()
        )
    }
}