package com.maiscommenosapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maiscommenosapp.model.MainViewModel
import com.maiscommenosapp.ui.PedidosPage
import com.maiscommenosapp.ui.PerfilMercadinho
import com.maiscommenosapp.ui.PerfilOng
import com.maiscommenosapp.ui.ProdutosPage

@Composable
fun MainNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { PedidosPage(viewModel = viewModel) }
        composable<Route.PerfilMercadinho> { PerfilMercadinho(viewModel = viewModel) }
        composable<Route.PerfilOng> { PerfilOng(viewModel = viewModel) }
        composable<Route.Produtos> { ProdutosPage(viewModel = viewModel) }
    }
}