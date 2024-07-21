package data.datasources

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email

interface SupabaseAuthDataSource {
    suspend fun signInUserWithEmailPasswordSupabase(userEmail: String, userPassword: String): Result<Unit>
}

class SupabaseAuthDataSourceImpl(
    private val supabaseClient: SupabaseClient
): SupabaseAuthDataSource {

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

}