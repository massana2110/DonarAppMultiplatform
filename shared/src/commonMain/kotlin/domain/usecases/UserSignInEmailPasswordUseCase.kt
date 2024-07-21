package domain.usecases

import domain.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserSignInEmailPasswordUseCase: KoinComponent {

    private val userRepository by inject<UserRepository>()

    suspend operator fun invoke(email: String, password: String) =
        userRepository.signInUserWithEmail(email, password)

}