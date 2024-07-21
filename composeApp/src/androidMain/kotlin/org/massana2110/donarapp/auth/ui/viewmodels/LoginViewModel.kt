package org.massana2110.donarapp.auth.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.usecases.UserSignInEmailPasswordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginUiState(
    val isLoggedIn: Boolean = false,
    val loginErrorMessage: String = ""
)

class LoginViewModel(
    private val signInEmailPasswordUseCase: UserSignInEmailPasswordUseCase
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> get() = _uiState

    fun onEmailTextChange(value: String) {
        email = value
    }

    fun onPasswordChange(value: String) {
        password = value
    }

    fun signInWithEmailPassword() {
        viewModelScope.launch {
            signInEmailPasswordUseCase(email, password)
                .onSuccess { _uiState.update { it.copy(isLoggedIn = true) } }
                .onFailure { e ->
                    println(e.message)
                    _uiState.update {
                        it.copy(
                            isLoggedIn = false,
                            loginErrorMessage = e.message.toString()
                        )
                    }
                }
        }
    }
}