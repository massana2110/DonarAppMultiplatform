package domain.repository

import io.github.jan.supabase.gotrue.user.UserSession

interface UserRepository {

    suspend fun signInUserWithEmail(email: String, password: String): Result<Unit>
    fun getCurrentUserSession(): UserSession?
    suspend fun signOutUser(): Result<Unit>
}