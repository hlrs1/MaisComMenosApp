package com.maiscommenosapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.maiscommenosapp.model.MainViewModel
import com.maiscommenosapp.ui.nav.BottomNavBar
import com.maiscommenosapp.ui.nav.BottomNavItem
import com.maiscommenosapp.ui.nav.MainNavHost
import com.maiscommenosapp.ui.ui.theme.MaisComMenosAppTheme

class IndexPageMercadinho : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel : MainViewModel by viewModels()
            val navController = rememberNavController()
            var showDialog by remember { mutableStateOf(false) }
            MaisComMenosAppTheme {
                if (showDialog) ProdutoDialog(
                    onDismiss = { showDialog = false },
                    onConfirm = { produto ->
                        if (produto.isNotBlank()) viewModel.addProduto(produto)
                        showDialog = false
                    })
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Bem-vindo(a) Mercadinho!") },

                            actions = {

                                IconButton( onClick = { finish() } ) {
                                    Icon(
                                        imageVector =
                                            Icons.AutoMirrored.Filled.ExitToApp,
                                        contentDescription = "Localized description"
                                    )
                                }
                            }
                        )
                    },

                    bottomBar = {
                        val items = listOf(
                            BottomNavItem.HomeButton,
                            BottomNavItem.ListButton,
                            BottomNavItem.MapButton,

                            )

                        BottomNavBar(navController = navController, items)

                    },

                    floatingActionButton = {

                        FloatingActionButton(onClick = { showDialog = true }) {
                            Icon(Icons.Default.Add, contentDescription = "Adicionar")
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainNavHost(navController = navController, viewModel = viewModel)
                    }

                }
            }
        }
    }
}

