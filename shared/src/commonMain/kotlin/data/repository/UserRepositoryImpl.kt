package data.repository

import data.datasources.SupabaseAuthDataSource
import domain.repository.UserRepository
import io.github.jan.supabase.gotrue.user.UserInfo
import io.github.jan.supabase.gotrue.user.UserSession

class UserRepositoryImpl(
    private val supabaseAuthDataSource: SupabaseAuthDataSource
) : UserRepository {

    override suspend fun signInUserWithEmail(
        email: String, password: String
    ): Result<Unit> = supabaseAuthDataSource.signInUserWithEmailPasswordSupabase(email, password)

    override suspend fun getCurrentUserSession(): UserInfo? = supabaseAuthDataSource.getCurrentSession()

    override suspend fun signOutUser(): Result<Unit> = supabaseAuthDataSource.singOutUser()

}