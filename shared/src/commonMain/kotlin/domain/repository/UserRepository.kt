package domain.repository

interface UserRepository {

    suspend fun signInUserWithEmail(email: String, password: String): Result<Unit>

}