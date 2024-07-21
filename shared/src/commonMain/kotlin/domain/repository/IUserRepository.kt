package domain.repository

interface IUserRepository {

    suspend fun signInUserWithEmail(email: String, password: String): Result<Unit>

}