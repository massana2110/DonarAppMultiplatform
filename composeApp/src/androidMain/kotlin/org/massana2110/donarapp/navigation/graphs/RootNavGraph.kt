package org.massana2110.donarapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.massana2110.donarapp.navigation.AuthRoute

@Composable
fun RootNav() {
    val rootNavController = rememberNavController()

    NavHost(rootNavController, startDestination = AuthRoute.OnBoarding.route) {
        authNavGraph(rootNavController)
    }
}