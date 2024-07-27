package domain.usecases.auth

import data.mappers.toDomain
import domain.models.auth.User
import domain.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetUserInSessionUseCase: KoinComponent {

    private val userRepository: UserRepository by inject()

    operator fun invoke(): User? = userRepository.getCurrentUserSession()?.user?.toDomain()

}