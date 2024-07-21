import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel
import org.massana2110.donarapp.auth.ui.screens.LoginScreen
import org.massana2110.donarapp.auth.ui.viewmodels.LoginViewModel

@Composable
fun DonarApp() {
    MaterialTheme {
        val loginViewModel: LoginViewModel = koinViewModel()
        val uiState by loginViewModel.uiState.collectAsState()

        LoginScreen(
            loginUiState = uiState,
            email = loginViewModel.email,
            password = loginViewModel.password,
            onEmailChange = loginViewModel::onEmailTextChange,
            onPasswordChange = loginViewModel::onPasswordChange,
            onLoginContinueClick = loginViewModel::signInWithEmailPassword
        )
    }
}