package com.maiscommenosapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maiscommenosapp.ui.IndexPageMercadinho
import com.maiscommenosapp.ui.IndexPageOng
import com.maiscommenosapp.ui.theme.MaisComMenosAppTheme

class LoginMercadinho : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaisComMenosAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginMercadinhoPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginMercadinhoPage(modifier: Modifier = Modifier) {
    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ) {
       Text(
                text = "MaisComMenosApp",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
       Text(
                text = "Mais benefício, menos desperdício",
                fontSize = 12.sp
            )

        OutlinedTextField(
            value = login,
            label = { Text(text = "Digite seu login") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { login = it }
        )
        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Row(modifier = modifier) {
            Button(
                onClick = {activity?.startActivity(
                    Intent(activity, IndexPageMercadinho::class.java).setFlags(
                        FLAG_ACTIVITY_SINGLE_TOP
                    )
                )
                    Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                },
                enabled = login.isNotEmpty() && password.isNotEmpty()
            ) {
                Text("Login")
            }
            Button(
                onClick = {
                    activity?.startActivity(
                        Intent(activity, RegistroMercadinho::class.java).setFlags(
                            FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                }
            ) {
                Text("Registre-se")
            }
            Button(
                onClick = { login = ""; password = "" },
                enabled = login.isNotEmpty() && password.isNotEmpty()
            ) {
                Text("Limpar")
            }

        }
        Spacer(modifier = modifier.size(30.dp))

        Row {
            Button(
                onClick = {
                    activity?.startActivity(
                        Intent(activity, MainActivity::class.java).setFlags(
                            FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                }
            ) {
                Text("Voltar")
            }
        }
    }
}