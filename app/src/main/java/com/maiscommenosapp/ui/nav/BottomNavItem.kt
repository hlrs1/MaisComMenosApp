package com.maiscommenosapp.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable


sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object List : Route
    @Serializable
    data object Map : Route
}
sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var route: Route
)
{
    data object HomeButton :
        BottomNavItem("Início", Icons.Default.Home, Route.Home)
    data object ListButton :
        BottomNavItem("Perfil", Icons.Default.Person, Route.List)
    data object MapButton :
        BottomNavItem("Produtos", Icons.Default.List, Route.Map)
}