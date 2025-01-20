package com.maiscommenosapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Dialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProdutoDialog(onDismiss: () -> Unit, onConfirm: (produto: String) -> Unit) {
    val produtoName = remember { mutableStateOf("") }
    val produtoQuantidade = remember { mutableStateOf("") }
    val produtoPreco = remember { mutableStateOf("") }
    Dialog(onDismissRequest = { onDismiss() } ) {
        Surface( shape = RoundedCornerShape(16.dp) ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Adicionar produto:")
                    Icon(imageVector = Icons.Filled.Close,
                        contentDescription = "",

                        modifier = Modifier.clickable { onDismiss() })

                }
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Nome do produto") },
                    value = produtoName.value,
                    onValueChange = { produtoName.value = it })
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Quantidade") },
                    value = produtoQuantidade.value,
                    onValueChange = { produtoQuantidade.value = it })
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Preço do produto") },
                    value = produtoPreco.value,
                    onValueChange = { produtoPreco.value = it })
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { onConfirm(produtoName.value) },
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) { Text(text = "OK") }
            }
        }
    }
}