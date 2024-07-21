package data.repository

import data.datasources.SupabaseAuthDataSource
import domain.repository.UserRepository

class UserRepositoryImpl(
    private val supabaseAuthDataSource: SupabaseAuthDataSource
) : UserRepository {

    override suspend fun signInUserWithEmail(
        email: String, password: String
    ): Result<Unit> = supabaseAuthDataSource.signInUserWithEmailPasswordSupabase(email, password)

}