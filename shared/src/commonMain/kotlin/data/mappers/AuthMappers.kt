package data.mappers

import domain.models.auth.User
import io.github.jan.supabase.gotrue.user.UserInfo

fun UserInfo.toDomain() = User(
    id = id,
    email = email,
    phone = phone
)