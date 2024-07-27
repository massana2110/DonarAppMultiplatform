import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.massana2110.donarapp.features.auth.ui.screens.LoginScreen
import org.massana2110.donarapp.features.auth.ui.viewmodels.LoginViewModel
import org.massana2110.donarapp.features.home.screens.MainScreen
import org.massana2110.donarapp.navigation.graphs.RootNav

@Composable
fun DonarApp() {
    MaterialTheme {
        // RootNav()
        MainScreen(rootNavHostController = rememberNavController())
    }
}