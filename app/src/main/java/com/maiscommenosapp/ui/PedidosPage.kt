package com.maiscommenosapp.ui

import android.app.Activity
import android.widget.Toast
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
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PedidosPage(modifier: Modifier = Modifier) {

    val pedidoList = remember { getPedido().toMutableStateList() }
    val activity = LocalContext.current as? Activity
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(pedidoList) { pedido ->
            PedidoItem(pedido = pedido, onClose = {
/* TO DO */

                Toast.makeText(activity, "Fechou!", Toast.LENGTH_LONG).show()
            }, onClick = {
/* TO DO */Toast.makeText(activity, "Clicou!", Toast.LENGTH_LONG).show()
            })
        }
    }
}

data class Pedido (
    val name : String,
    val quantidade: String? = null,
    val preco: String? = null
)

private fun getPedido() = List(20) { i ->
    Pedido(name = "Arroz $i", quantidade = "10", preco = "18,00")
}

@Composable
fun PedidoItem(
    pedido: Pedido,
    onClick: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(8.dp).clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Rounded.FavoriteBorder,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column(modifier = modifier.weight(1f)) {
            Text(modifier = Modifier,
                text = pedido.name,
                fontSize = 24.sp)
            Text(modifier = Modifier,
                text = pedido.quantidade?:"10",

                fontSize = 16.sp)

        }
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

