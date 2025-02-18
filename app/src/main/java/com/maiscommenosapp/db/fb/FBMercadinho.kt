package com.maiscommenosapp.db.fb

import com.maiscommenosapp.model.Mercadinho

class FBMercadinho {
    var name : String ? = null
    var email : String? = null
    var cnpj : String? = null
    var telefone : String? = null
    var endereco : String? = null
    var tipo : String? = null
    fun toMercadinho() = Mercadinho(name!!, email!!, tipo!!, cnpj!!, endereco!!, telefone!!)
}
fun Mercadinho.toFBMercadinho() : FBMercadinho {
    val fbMercadinho= FBMercadinho()
    fbMercadinho.name = this.name
    fbMercadinho.email = this.email
    fbMercadinho.cnpj = this.cnpj
    fbMercadinho.endereco = this.endereco
    fbMercadinho.tipo = this.tipo
    fbMercadinho.telefone = this.telefone

    return fbMercadinho
}
