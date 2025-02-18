package com.maiscommenosapp.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maiscommenosapp.model.MainViewModel
import com.maiscommenosapp.model.User

@Preview(showBackground = true)
@Composable
fun PerfilMercadinho(viewModel: MainViewModel) {

    GreetingImage("perfilmercadinho")

    val activity = LocalContext.current as? Activity
    ContentPerfil(Modifier, viewModel)



}

@Composable
fun ContentPerfil(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val mercadinho = viewModel.mercadinho
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        if (mercadinho != null) {
            Row(
                modifier = modifier.fillMaxWidth().background(Color(255, 255, 255, 200))
                    .padding(8.dp).clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ("Nome: " + mercadinho.name),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Row(
                modifier = modifier.fillMaxWidth().background(Color(255, 255, 255, 200))
                    .padding(8.dp).clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ("Email: " + mercadinho.email),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Row(
                modifier = modifier.fillMaxWidth().background(Color(255, 255, 255, 200))
                    .padding(8.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ("CNPJ: " + mercadinho.cnpj),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Row(
                modifier = modifier.fillMaxWidth().background(Color(255, 255, 255, 200))
                    .padding(8.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ("Telefone: " + mercadinho.telefone),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }


    }
}




