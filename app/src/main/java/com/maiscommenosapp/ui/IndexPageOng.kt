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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.maiscommenosapp.db.fb.FBDatabase
import com.maiscommenosapp.model.MainViewModel
import com.maiscommenosapp.model.MainViewModelFactory
import com.maiscommenosapp.ui.nav.BottomNavBar
import com.maiscommenosapp.ui.nav.BottomNavItem
import com.maiscommenosapp.ui.nav.MainNavHost
import com.maiscommenosapp.ui.ui.theme.MaisComMenosAppTheme

class IndexPageOng : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val fbDB = remember { FBDatabase() }
            val viewModel : MainViewModel = viewModel(
                factory = MainViewModelFactory(fbDB)
            )
            val navController = rememberNavController()
            var showDialog by remember { mutableStateOf(false) }
            MaisComMenosAppTheme {
                if (showDialog) ProdutoDialog(
                    onDismiss = { showDialog = false },
                    onConfirm = { nome, quantidade, preco ->
                        if (nome.isNotBlank()&&quantidade<0&&preco>0)
                            viewModel.add(nome, quantidade, preco)
                        showDialog = false
                    })
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Bem-vindo(a) Ong!") },

                            actions = {

                                IconButton( onClick = { Firebase.auth.signOut()
                                    finish() } ) {
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
                            BottomNavItem.ProdutoButton,
                            BottomNavItem.PerfilOng,
                            BottomNavItem.HomeButton,

                            )

                        BottomNavBar(navController = navController, items)

                    },

                    /*floatingActionButton = {

                        FloatingActionButton(onClick = { showDialog = true }) {
                            Icon(Icons.Default.Add, contentDescription = "Adicionar")
                        }
                    }*/
                ) { innerPadding ->
                    GreetingImage("hello", from = "Me")
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainNavHost(navController = navController, viewModel = viewModel)
                    }
                    ProdutosPage(
                        modifier = Modifier,
                        viewModel = viewModel
                    )


                }
            }
        }
    }
}