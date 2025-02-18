package com.maiscommenosapp.ui.nav

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maiscommenosapp.db.fb.FBDatabase
import com.maiscommenosapp.model.MainViewModel
import com.maiscommenosapp.model.MainViewModelFactory
import com.maiscommenosapp.ui.OfertasPage
import com.maiscommenosapp.ui.PedidosPage
import com.maiscommenosapp.ui.PerfilMercadinho
import com.maiscommenosapp.ui.PerfilOng
import com.maiscommenosapp.ui.ProdutosPage
import com.maiscommenosapp.ui.nav.Route

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainNavHost(navController: NavHostController, viewModel: MainViewModel) {
    val fbDB = remember { FBDatabase() }
    val viewModel1 : MainViewModel = viewModel(
        factory = MainViewModelFactory(fbDB)
    )
        if(viewModel1.ong != null) {
            NavHost(navController, startDestination = Route.Home) {

                composable<Route.Home> { OfertasPage(viewModel = viewModel) }
                composable<Route.PerfilOng> { PerfilOng(viewModel = viewModel) }
            }
        }else
            {
                NavHost(navController, startDestination = Route.Home) {
                    composable<Route.Home> { ProdutosPage(viewModel = viewModel) }
                    composable<Route.PerfilMercadinho> { PerfilMercadinho(viewModel = viewModel) }
                }
        }

}