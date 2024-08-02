package org.massana2110.donarapp.features.home.models

import androidx.annotation.DrawableRes
import org.massana2110.donarapp.R

data class DonationItemModel(
    val id: Int,
    @DrawableRes val imgOrganization: Int,
    @DrawableRes val logoOrganization: Int,
    val name: String,
    val category: String,
    val shortDescription: String,
    val longDescription: String,
    val styledDescription: String,
    val extraDescription: String
)

val listDonationOrganizations = listOf(
    DonationItemModel(
        id = 1,
        imgOrganization = R.drawable.arani,
        logoOrganization = R.drawable.arani_logo,
        name = "Arani El Salvador",
        category = "Animalista",
        shortDescription = "Ayudamos a animales en condiciones de abandono",
        longDescription = "Somos una asociación que busca ayudar a perros y gatos que viven en condiciones de abandono.\n" +
                "Nuestra misión es clara y apasionada: brindar refugio, atención médica, amor y una segunda oportunidad a los " +
                "animales en situaciones de abandono, maltrato o en peligro.\n",
        styledDescription = "Cada latido de su corazón merece ser escuchado, y estamos aquí para ser su voz.\n",
        extraDescription = "Nuestra labor no sería posible sin el apoyo de personas generosas como tú. Tu tiempo, donaciones y " +
                "amor por los animales son el motor que impulsa nuestro compromiso."
    ),
    DonationItemModel(
        id = 2,
        imgOrganization = R.drawable.manada_pick_alt,
        logoOrganization = R.drawable.manada_pick,
        name = "La Manada de Pick",
        category = "Animalista",
        shortDescription = "Brindamos una segunda oportunidad a los animales",
        longDescription = "Somos una asociación que busca ayudar a perros y gatos que viven en condiciones de abandono.\n" +
                "Nuestra misión es clara y apasionada: brindar refugio, atención médica, amor y una segunda oportunidad a los " +
                "animales en situaciones de abandono, maltrato o en peligro.\n",
        styledDescription = "Cada latido de su corazón merece ser escuchado, y estamos aquí para ser su voz.\n",
        extraDescription = "Nuestra labor no sería posible sin el apoyo de personas generosas como tú. Tu tiempo, donaciones y " +
                "amor por los animales son el motor que impulsa nuestro compromiso."
    ),
    DonationItemModel(
        id = 3,
        imgOrganization = R.drawable.huellitas,
        logoOrganization = R.drawable.huellitas_alt,
        name = "Huellitas",
        category = "Animalista",
        shortDescription = "Somos un refugio para animalitos en abandono",
        longDescription = "Somos una asociación que busca ayudar a perros y gatos que viven en condiciones de abandono.\n" +
                "Nuestra misión es clara y apasionada: brindar refugio, atención médica, amor y una segunda oportunidad a los " +
                "animales en situaciones de abandono, maltrato o en peligro.\n",
        styledDescription = "Cada latido de su corazón merece ser escuchado, y estamos aquí para ser su voz.\n",
        extraDescription = "Nuestra labor no sería posible sin el apoyo de personas generosas como tú. Tu tiempo, donaciones y " +
                "amor por los animales son el motor que impulsa nuestro compromiso."
    ),
    DonationItemModel(
        id = 4,
        imgOrganization = R.drawable.jardin_peludos,
        logoOrganization = R.drawable.jardin_peludos_logo,
        name = "Mi Jardín de peludos",
        category = "Animalista",
        shortDescription = "Ayudamos a animales en condiciones de abandono",
        longDescription = "Somos una asociación que busca ayudar a perros y gatos que viven en condiciones de abandono.\n" +
                "Nuestra misión es clara y apasionada: brindar refugio, atención médica, amor y una segunda oportunidad a los " +
                "animales en situaciones de abandono, maltrato o en peligro.\n",
        styledDescription = "Cada latido de su corazón merece ser escuchado, y estamos aquí para ser su voz.\n",
        extraDescription = "Nuestra labor no sería posible sin el apoyo de personas generosas como tú. Tu tiempo, donaciones y " +
                "amor por los animales son el motor que impulsa nuestro compromiso."
    ),
)