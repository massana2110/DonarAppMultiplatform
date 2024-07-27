package org.massana2110.donarapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import org.massana2110.donarapp.theme.BluePrimary
import org.massana2110.donarapp.theme.LightGraySecondary
import org.massana2110.donarapp.theme.interFontFamily

data class BottomAppBarOption(
    val title: String,
    val icon: ImageVector,
    val screen: MainRoutes
)

private val listOptions = listOf(
    BottomAppBarOption("Inicio", Icons.Outlined.Home, MainRoutes.Home),
    BottomAppBarOption("Donar", Icons.Outlined.FavoriteBorder, MainRoutes.Donate),
    BottomAppBarOption("Cuenta", Icons.Outlined.Person, MainRoutes.Profile)
)

@Composable
fun DonarBottomAppBar(
    currentDestination: NavDestination?,
    onClickItem: (MainRoutes) -> Unit
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        listOptions.forEachIndexed { _, bottomAppBarOption ->
            NavigationBarItem(
                label = {
                    Text(
                        text = bottomAppBarOption.title,
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == bottomAppBarOption.screen.route } == true,
                onClick = {
                    onClickItem(bottomAppBarOption.screen)
                },
                icon = {
                    Icon(
                        imageVector = bottomAppBarOption.icon,
                        contentDescription = bottomAppBarOption.title
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                    selectedIconColor = BluePrimary,
                    selectedTextColor = BluePrimary,
                    unselectedIconColor = LightGraySecondary,
                    unselectedTextColor = LightGraySecondary
                )
            )
        }
    }
}