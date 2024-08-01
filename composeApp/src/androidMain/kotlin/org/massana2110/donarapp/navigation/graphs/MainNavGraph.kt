package org.massana2110.donarapp.navigation.graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel
import org.massana2110.donarapp.features.home.screens.HomeScreen
import org.massana2110.donarapp.features.home.screens.ProfileScreen
import org.massana2110.donarapp.features.home.viewmodels.ProfileViewModel
import org.massana2110.donarapp.navigation.AuthRoute
import org.massana2110.donarapp.navigation.MainRoutes
import org.massana2110.donarapp.navigation.NavigationGraph

@Composable
fun MainNavGraph(
    rootNavHostController: NavHostController,
    homeNavHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    NavHost(
        navController = homeNavHostController,
        startDestination = MainRoutes.Home.route
    ) {
        composable(route = MainRoutes.Home.route) {
            HomeScreen(modifier = Modifier.padding(innerPaddingValues))
        }
        composable(route = MainRoutes.Donate.route) {
            Text(text = "Donate Screen", Modifier.padding(innerPaddingValues))
        }
        composable(route = MainRoutes.Profile.route) {
            val profileViewModel: ProfileViewModel = koinViewModel()
            val uiState by profileViewModel.uiState.collectAsState()

            ProfileScreen(
                modifier = Modifier.padding(innerPaddingValues),
                profileUiState = uiState,
                onLogoutClick = profileViewModel::onSignOut,
                onLogoutSuccess = {
                    rootNavHostController.navigate(AuthRoute.Login.route) {
                        popUpTo(NavigationGraph.MainGraph.graph) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }
    }
}