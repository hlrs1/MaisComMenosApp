package com.maiscommenosapp.db.fb

import com.maiscommenosapp.model.Produto

class FBProduto {
        var name : String? = null
        var quantidade : Int? = null
        var preco : Double? = null

        fun toProduto(): Produto {
            val qtd = quantidade
            return Produto(this.name!!,quantidade = qtd,preco = preco)
        }
    }
    fun Produto.toFBProduto() : FBProduto {
        val fbProduto = FBProduto()
        fbProduto.name = this.name
        fbProduto.quantidade = this.quantidade
        fbProduto.preco = this.preco
        return fbProduto
    }

