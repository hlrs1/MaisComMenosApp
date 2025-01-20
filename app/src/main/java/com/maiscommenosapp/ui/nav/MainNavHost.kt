package com.maiscommenosapp.ui.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maiscommenosapp.ui.IndexPage
import com.maiscommenosapp.ui.PedidosPage
import com.maiscommenosapp.ui.PerfilMercadinho
import com.maiscommenosapp.ui.ProdutosPage
import com.maiscommenosapp.ui.nav.ui.theme.MaisComMenosAppTheme

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { PedidosPage() }
        composable<Route.List> { PerfilMercadinho() }
        composable<Route.Map> { ProdutosPage() }
    }
}