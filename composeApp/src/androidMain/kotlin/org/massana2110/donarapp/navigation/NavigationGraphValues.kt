package org.massana2110.donarapp.navigation

import kotlinx.serialization.Serializable

// Graphs
sealed class NavigationGraph(val graph: String) {
    data object RootGraph: NavigationGraph("rootGraph")
    data object AuthGraph: NavigationGraph("authGraph")
    data object MainGraph: NavigationGraph("mainGraph")
    data object DonationGraph: NavigationGraph("donationGraph")
}

// Routes inside auth graph
sealed class AuthRoute(val route: String) {
    data object OnBoarding: AuthRoute("onboarding")
    data object Login: AuthRoute("login")
}

// Routes inside main graph
sealed class MainRoutes(val route: String) {
    data object Home: MainRoutes("home")
    data object Donate: MainRoutes("donate")
    data object Profile: MainRoutes("profile")
}

// Routes inside donate graph
sealed class DonationRoutes(val route: String) {
    data object DonationDetail: DonationRoutes("donation_detail")
    data object DonationQuantity: DonationRoutes("donation_quantity")
    data object DonationConfirmation: DonationRoutes("donation_confirmation")
}

