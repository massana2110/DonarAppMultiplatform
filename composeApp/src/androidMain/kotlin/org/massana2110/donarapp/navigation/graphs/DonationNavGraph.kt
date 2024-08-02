package org.massana2110.donarapp.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.massana2110.donarapp.features.donate.screens.DonateDetailScreen
import org.massana2110.donarapp.navigation.DonationRoutes
import org.massana2110.donarapp.navigation.NavigationGraph

fun NavGraphBuilder.donationGraph(
    rootNavHostController: NavHostController
) {
    navigation(
        startDestination = DonationRoutes.DonationDetail.route,
        route = NavigationGraph.DonationGraph.graph
    ) {
        composable(route = DonationRoutes.DonationDetail.route) {
            DonateDetailScreen()
        }
    }
}