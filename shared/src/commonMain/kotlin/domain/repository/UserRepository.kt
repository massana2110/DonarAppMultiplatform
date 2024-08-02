package domain.repository

import io.github.jan.supabase.gotrue.user.UserInfo
import io.github.jan.supabase.gotrue.user.UserSession

interface UserRepository {

    suspend fun signInUserWithEmail(email: String, password: String): Result<Unit>
    suspend fun getCurrentUserSession(): UserInfo?
    suspend fun signOutUser(): Result<Unit>
}