package domain.models.auth

data class User(
    val id: String,
    val email: String?,
    val phone: String?,
)
