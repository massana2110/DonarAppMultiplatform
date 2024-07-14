import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource

import donarappmultiplatform.composeapp.generated.resources.Res
import donarappmultiplatform.composeapp.generated.resources.compose_multiplatform
import org.massana2110.donarapp.auth.ui.screens.LoginScreen

@Composable
fun App() {
    MaterialTheme {
        LoginScreen()
    }
}