package di

import data.datasources.SupabaseAuthDataSource
import data.datasources.SupabaseAuthDataSourceImpl
import data.repository.UserRepositoryImpl
import domain.repository.UserRepository
import domain.usecases.auth.GetUserInSessionUseCase
import domain.usecases.auth.UserSignInEmailPasswordUseCase
import domain.usecases.auth.UserSignOutUseCase
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.dsl.module

val supabaseModule = module {
    single {
        createSupabaseClient(
            supabaseUrl = "https://geyqjqkihsizrykqezgu.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImdleXFqcWtpaHNpenJ5a3Flemd1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjExNTkyMzIsImV4cCI6MjAzNjczNTIzMn0.9v-1JBARIvA3G7vhsyPo4LKQb6JFKMQfT31YimTXZFk"
        ) {
            install(Postgrest)
            install(Auth)
        }
    }
}

val dataModule = module {
    factory<SupabaseAuthDataSource> {
        SupabaseAuthDataSourceImpl(supabaseClient = get())
    }
}

val domainModule = module {
    single<UserRepository> { UserRepositoryImpl(supabaseAuthDataSource = get()) }

    // use cases
    factory { UserSignInEmailPasswordUseCase() }
    factory { GetUserInSessionUseCase() }
    factory { UserSignOutUseCase() }
}

private val sharedModules = listOf(supabaseModule, dataModule, domainModule)

fun getSharedModules() = sharedModules