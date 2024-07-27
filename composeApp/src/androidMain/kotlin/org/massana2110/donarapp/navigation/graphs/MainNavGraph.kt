package org.massana2110.donarapp.navigation.graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.massana2110.donarapp.navigation.MainRoutes
import org.massana2110.donarapp.navigation.NavigationGraph

@Composable
fun MainNavGraph(
    rootNavHostController: NavHostController,
    homeNavHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    NavHost(navController = homeNavHostController, startDestination = MainRoutes.Home.route, route = NavigationGraph.MainGraph.graph) {
        composable(route = MainRoutes.Home.route) {
            Column {
                Text(text = "Home Screen", Modifier.padding(innerPaddingValues))
                Button(onClick = {  }) {
                    Text(text = "Logout")
                }
            }
        }
        composable(route = MainRoutes.Donate.route) {
            Text(text = "Donate Screen", Modifier.padding(innerPaddingValues))
        }
        composable(route = MainRoutes.Profile.route) {
            Text(text = "Profile Screen", Modifier.padding(innerPaddingValues))
        }
    }
}