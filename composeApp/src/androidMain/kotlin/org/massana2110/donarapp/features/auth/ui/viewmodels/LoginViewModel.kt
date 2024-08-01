package org.massana2110.donarapp.features.auth.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.usecases.auth.GetUserInSessionUseCase
import domain.usecases.auth.UserSignInEmailPasswordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginUiState(
    val isLoading: Boolean = false,
    val isLoggedInSuccess: Boolean = false,
    val loginErrorMessage: String = ""
)

class LoginViewModel(
    private val signInEmailPasswordUseCase: UserSignInEmailPasswordUseCase,
    private val getUserInSessionUseCase: GetUserInSessionUseCase
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> get() = _uiState

    init {
        val user = getUserInSessionUseCase()
        if (user != null) {
            _uiState.update { it.copy(isLoading = false, isLoggedInSuccess = true) }
        }
    }

    fun onEmailTextChange(value: String) {
        email = value
    }

    fun onPasswordChange(value: String) {
        password = value
    }

    fun resetLoginResult() {
        _uiState.update { it.copy(isLoggedInSuccess = false, loginErrorMessage = "") }
    }

    fun signInWithEmailPassword() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            signInEmailPasswordUseCase(email, password)
                .onSuccess {
                    val user = getUserInSessionUseCase()

                    if (user != null)
                        _uiState.update { it.copy(isLoading = false, isLoggedInSuccess = true) }
                }
                .onFailure { e ->
                    println(e.message)
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isLoggedInSuccess = false,
                            loginErrorMessage = e.message.toString()
                        )
                    }
                }
        }
    }
}