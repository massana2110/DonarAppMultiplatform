package data.datasources

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.user.UserInfo
import io.github.jan.supabase.gotrue.user.UserSession

interface SupabaseAuthDataSource {
    suspend fun getCurrentSession(): UserInfo?
    suspend fun signInUserWithEmailPasswordSupabase(userEmail: String, userPassword: String): Result<Unit>
    suspend fun singOutUser(): Result<Unit>
}

class SupabaseAuthDataSourceImpl(
    private val supabaseClient: SupabaseClient
): SupabaseAuthDataSource {

    override suspend fun getCurrentSession(): UserInfo? {
        return try {
            supabaseClient.auth.retrieveUserForCurrentSession(updateSession = true)
        } catch (_: Exception) {
            null
        }
    }

    override suspend fun signInUserWithEmailPasswordSupabase(userEmail: String, userPassword: String): Result<Unit> {
        return try {
            supabaseClient.auth.signInWith(Email) {
                email = userEmail
                password = userPassword
            }
            Result.success(Unit)
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