package data.datasources

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email

interface ISupabaseAuthDataSource {
    suspend fun signInUserWithEmailPasswordSupabase()
}

class SupabaseAuthDataSourceImpl(
    private val supabaseClient: SupabaseClient
): ISupabaseAuthDataSource {

    override suspend fun signInUserWithEmailPasswordSupabase() {
        supabaseClient.auth.signInWith(Email) {

        }
    }

}