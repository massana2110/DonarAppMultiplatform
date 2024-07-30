package org.massana2110.donarapp.features.home.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.usecases.auth.UserSignOutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ProfileUiState(
    val isUserLogout: Boolean = false,
    val errorMessage: String = "",
)

class ProfileViewModel(
    private val userSignOutUseCase: UserSignOutUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> get() = _uiState

    fun onSignOut() {
        viewModelScope.launch {
            userSignOutUseCase()
                .onSuccess {
                    _uiState.update { it.copy(isUserLogout = true) }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(errorMessage = e.message.toString()) }
                }
        }
    }

}