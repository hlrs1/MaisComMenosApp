package com.maiscommenosapp.db.fb

import com.maiscommenosapp.model.Produto
import java.util.Date

class FBProduto {
        var name : String? = null
        var quantidade : Int? = null
        var preco : Double? = null
        var validade: Date? = null

        fun toProduto(): Produto {
            val qtd = quantidade
            return Produto(this.name!!,quantidade = qtd,preco = preco!!, validade = Date())
        }
    }
    fun Produto.toFBProduto() : FBProduto {
        val fbProduto = FBProduto()
        fbProduto.name = this.name
        fbProduto.quantidade = this.quantidade
        fbProduto.preco = this.preco
        fbProduto.validade = this.validade
        return fbProduto
    }

