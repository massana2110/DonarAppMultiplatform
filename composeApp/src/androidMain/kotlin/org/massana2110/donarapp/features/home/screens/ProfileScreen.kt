package org.massana2110.donarapp.features.home.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.massana2110.donarapp.features.home.components.CustomTopBar
import org.massana2110.donarapp.features.home.components.ProfileDonationsList
import org.massana2110.donarapp.features.home.components.ProfileHeader
import org.massana2110.donarapp.features.home.components.ProfileLogoutModal
import org.massana2110.donarapp.features.home.viewmodels.ProfileUiState
import org.massana2110.donarapp.theme.BluePrimary

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileUiState: ProfileUiState,
    onLogoutClick: () -> Unit,
    onLogoutSuccess: () -> Unit
) {
    var isShowLogoutModal by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(profileUiState.isUserLogout) {
        if (profileUiState.isUserLogout) {
            onLogoutSuccess()
        }
    }

    Column(modifier = modifier) {
        CustomTopBar(title = "Mi perfil") {
            IconButton(onClick = { isShowLogoutModal = true }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ExitToApp,
                    contentDescription = "Exit",
                    tint = BluePrimary
                )
            }
        }

        ProfileHeader()
        ProfileDonationsList(modifier = Modifier.padding(16.dp))

        // logout modal
        AnimatedVisibility(visible = isShowLogoutModal) {
            ProfileLogoutModal(
                onDismiss = { isShowLogoutModal = false },
                onContinueClick = { onLogoutClick() }
            )
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(
        profileUiState = ProfileUiState(),
        onLogoutClick = {},
        onLogoutSuccess = {}
    )
}