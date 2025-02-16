package com.maiscommenosapp.db.fb

import com.maiscommenosapp.model.Pedido

class FBPedido {
    var name : String? = null
    var quantidade : String? = null
    var preco : String? = null

    fun toPedido(): Pedido {
        val qtd = quantidade
        return Pedido(this.name!!,quantidade = qtd,preco = preco)
    }
}
fun Pedido.toFBPedido() : FBPedido {
    val fbPedido = FBPedido()
    fbPedido.name = this.name
    fbPedido.quantidade = this.quantidade
    fbPedido.preco = this.preco
    return fbPedido
}
