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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maiscommenosapp.ui.theme.MaisComMenosAppTheme

class RegistroOng : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaisComMenosAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterOngPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterOngPage(modifier: Modifier = Modifier) {

    var nome by rememberSaveable { mutableStateOf("") }
    Spacer(modifier = modifier.size(24.dp))
    var login by rememberSaveable { mutableStateOf("") }
    Spacer(modifier = modifier.size(24.dp))
    var telefone by rememberSaveable { mutableStateOf("") }
    Spacer(modifier = modifier.size(24.dp))
    var endereco by rememberSaveable { mutableStateOf("") }
    Spacer(modifier = modifier.size(24.dp))
    var password by rememberSaveable { mutableStateOf("") }
    Spacer(modifier = modifier.size(24.dp))
    var confirmacao by rememberSaveable { mutableStateOf("") }
    Spacer(modifier = modifier.size(24.dp))
    val activity = LocalContext.current as? Activity
    Spacer(modifier = modifier.size(24.dp))
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ) {
        Text(
            text = "Registre-se!",
            fontSize = 24.sp
        )

        Spacer(modifier = modifier.size(24.dp))
        OutlinedTextField(
            value = nome,
            label = { Text(text = "Digite o nome da ONG") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { nome = it }
        )
        OutlinedTextField(
            value = login,
            label = { Text(text = "Digite seu login") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { login = it }
        )
        OutlinedTextField(
            value = telefone,
            label = { Text(text = "Digite seu telefone") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { telefone = it }
        )
        OutlinedTextField(
            value = endereco,
            label = { Text(text = "Digite seu endereço") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { endereco = it }
        )
        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = confirmacao,
            label = { Text(text = "Confirme sua senha") },
            modifier = modifier.fillMaxWidth(),
            onValueChange = { confirmacao = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Row(modifier = modifier) {
            Button(
                onClick = {
                    Toast.makeText(activity, "ONG Registrada!", Toast.LENGTH_LONG).show()
                    activity?.startActivity(
                        Intent(activity, LoginOng::class.java).setFlags(
                            FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                },
                enabled = nome.isNotEmpty() && telefone.isNotEmpty()&& login.isNotEmpty()&& endereco.isNotEmpty() && password.isNotEmpty() && confirmacao.isNotEmpty()
                        && (password == confirmacao)
            ) {
                Text("Registrar")
            }
            Spacer(modifier = modifier.size(24.dp))
            Button(
                onClick = { login = ""; password = ""; confirmacao = ""; nome = ""; telefone = ""; endereco = ""}
            ) {
                Text("Limpar")
            }
        }
    }
}