package com.maiscommenosapp.model

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maiscommenosapp.db.fb.FBDatabase

class MainViewModel  (private val db: FBDatabase): ViewModel(),
    FBDatabase.Listener {
    private val _pedidos = mutableStateMapOf<String,Pedido>()
    val pedidos : List<Pedido>
        get() = _pedidos.values.toList()

    private val _produtos = mutableStateMapOf<String,Produto>()
    val produtos : List<Produto>
        get() = _produtos.values.toList()

    private val _user = mutableStateOf<User?> (null)
    val user : User?
        get() = _user.value

    private val _mercadinho = mutableStateOf<Mercadinho?> (null)
    val mercadinho : Mercadinho?
        get() = _mercadinho.value

    /*fun addProduto(name: String) {
        _produtos.add(Produto(name = name))
    }*/
    init {
        db.setListener(this)
    }

    fun remove(pedido: Pedido) {
        db.removePedido(pedido)
    }
    fun add(name: String, quantidade: String, preco: String) {
        db.addPedido(Pedido(name = name, quantidade = quantidade, preco = preco))
    }

    fun remove(produto: Produto) {
        db.removeProduto(produto)
    }
    fun add(name: String, quantidade: Int, preco: Double) {
        db.addProduto(Produto(name = name, quantidade = quantidade, preco = preco))
    }

    override fun onUserLoaded(user: User) {
        _user.value = user
    }

    override fun onMercadinhoLoaded(mercadinho: Mercadinho) {
        _mercadinho.value = mercadinho
    }

    override fun onPedidoAdded(pedido: Pedido) {
        _pedidos[pedido.name]= pedido
    }

    override fun onPedidoUpdated(pedido: Pedido) {
        _pedidos.remove(pedido.name)
        _pedidos[pedido.name]= pedido.copy()
    }
    override fun onPedidoRemoved(pedido: Pedido) {
        _pedidos.remove(pedido.name)
    }

    override fun onProdutoAdded(produto: Produto) {
        _produtos[produto.name]= produto
    }
    override fun onProdutoUpdated(produto: Produto) {
        _produtos.remove(produto.name)
        _produtos[produto.name]= produto.copy()
    }
    override fun onProdutoRemoved(produto: Produto) {
        _produtos.remove(produto.name)
    }

}

class MainViewModelFactory(private val db : FBDatabase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

private fun getPedido() = List(20) { i ->
    Pedido(name = "Arroz $i", quantidade = "10", preco = "18,00")
}

private fun getProduto() = List(20) { i ->
    Produto(name = "Arroz $i", quantidade = 10, preco = 18.00)
}
