package di

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.dsl.module
import kotlin.math.sin

val supabaseModule = module {
    single {
        createSupabaseClient(
            supabaseUrl = "",
            supabaseKey = ""
        ) {
            install(Postgrest)
            install(Auth)
        }
    }
}