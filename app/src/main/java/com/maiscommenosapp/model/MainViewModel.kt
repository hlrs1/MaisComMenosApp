package com.maiscommenosapp.model

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _pedidos = getPedido().toMutableStateList()
    val pedidos
        get() = _pedidos.toList()
    fun remove(pedido: Pedido) {
        _pedidos.remove(pedido)
    }
    fun addPedido(name: String) {
        _pedidos.add(Pedido(name = name))
    }

    private val _produtos = getProduto().toMutableStateList()
    val produtos
        get() = _produtos.toList()
    fun remove(produto: Produto) {
        _produtos.remove(produto)
    }
    fun addProduto(name: String) {
        _produtos.add(Produto(name = name))
    }
}

private fun getPedido() = List(20) { i ->
    Pedido(name = "Arroz $i", quantidade = "10", preco = "18,00")
}

private fun getProduto() = List(20) { i ->
    Produto(name = "Arroz $i", quantidade = "10", preco = "18,00")
}
