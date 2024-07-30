package domain.usecases.auth

import domain.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserSignOutUseCase: KoinComponent {

    private val userRepository by inject<UserRepository>()

    suspend operator fun invoke() = userRepository.signOutUser()

}