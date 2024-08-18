package data.datasources

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.user.UserInfo
import io.github.jan.supabase.gotrue.user.UserSession

typealias JwtToken = String

interface SupabaseAuthDataSource {
    suspend fun getCurrentSession(token: JwtToken): UserInfo?
    suspend fun signInUserWithEmailPasswordSupabase(userEmail: String, userPassword: String): Result<JwtToken>
    suspend fun singOutUser(): Result<Unit>
}

class SupabaseAuthDataSourceImpl(
    private val supabaseClient: SupabaseClient
): SupabaseAuthDataSource {

    override suspend fun getCurrentSession(token: JwtToken): UserInfo? {
        return try {
            val user = supabaseClient.auth.retrieveUser(token)
            supabaseClient.auth.refreshCurrentSession()
            user
        } catch (_: Exception) {
            null
        }
    }

    override suspend fun signInUserWithEmailPasswordSupabase(userEmail: String, userPassword: String): Result<JwtToken> {
        return try {
            supabaseClient.auth.signInWith(Email) {
                email = userEmail
                password = userPassword
            }
            val token = supabaseClient.auth.currentAccessTokenOrNull()
            Result.success(token ?: "")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun singOutUser(): Result<Unit> {
        return try {
            supabaseClient.auth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}