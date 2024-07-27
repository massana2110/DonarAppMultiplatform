package org.massana2110.donarapp.navigation.graphs

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.koin.androidx.compose.koinViewModel
import org.massana2110.donarapp.features.auth.ui.screens.LoginScreen
import org.massana2110.donarapp.features.auth.ui.screens.OnBoardingScreen
import org.massana2110.donarapp.features.auth.ui.viewmodels.LoginViewModel
import org.massana2110.donarapp.navigation.AuthRoute
import org.massana2110.donarapp.navigation.NavigationGraph

fun NavGraphBuilder.authNavGraph(rootNavHostController: NavHostController) {
    navigation(startDestination = AuthRoute.OnBoarding.route, route = NavigationGraph.AuthGraph.graph) {
        composable(route = AuthRoute.OnBoarding.route) {
            OnBoardingScreen()
        }
        composable(route = AuthRoute.Login.route) {
            val loginViewModel: LoginViewModel = koinViewModel()
            val uiState by loginViewModel.uiState.collectAsState()

            LoginScreen(
                loginUiState = uiState,
                email = loginViewModel.email,
                password = loginViewModel.password,
                onEmailChange = loginViewModel::onEmailTextChange,
                onPasswordChange = loginViewModel::onPasswordChange,
                onLoginContinueClick = loginViewModel::signInWithEmailPassword,
                onLoginSuccessful = {
                    rootNavHostController.navigate(NavigationGraph.MainGraph.graph)
                }
            )
        }
    }
}