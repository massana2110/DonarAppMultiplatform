package org.massana2110.donarapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.massana2110.donarapp.features.home.screens.MainScreen
import org.massana2110.donarapp.navigation.AuthRoute
import org.massana2110.donarapp.navigation.NavigationGraph

@Composable
fun RootNav() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = NavigationGraph.AuthGraph.graph,
        route = NavigationGraph.RootGraph.graph
    ) {
        authNavGraph(rootNavController)
        composable(route = NavigationGraph.MainGraph.graph) {
            MainScreen(rootNavHostController = rootNavController)
        }
        donationGraph(rootNavController)
    }
}