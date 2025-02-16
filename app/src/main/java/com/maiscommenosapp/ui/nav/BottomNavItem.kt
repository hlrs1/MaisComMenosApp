package com.maiscommenosapp.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable


sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object PerfilOng : Route
    @Serializable
    data object PerfilMercadinho : Route
    @Serializable
    data object Produtos : Route
}
sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var route: Route
)
{
    data object HomeButton :
        BottomNavItem("Início", Icons.Default.Home, Route.Home)
    data object PerfilOng :
        BottomNavItem("Perfil", Icons.Default.Person, Route.PerfilOng)
    data object PerfilMercadinho :
        BottomNavItem("Perfil", Icons.Default.Person, Route.PerfilMercadinho)
    data object ProdutoButton:
        BottomNavItem("Produtos", Icons.Default.List, Route.Produtos)
}