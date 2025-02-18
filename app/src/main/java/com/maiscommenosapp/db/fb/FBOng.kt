package com.maiscommenosapp.db.fb

import com.maiscommenosapp.model.Ong

class FBOng {
    var name : String ? = null
    var email : String? = null
    var telefone : String? = null
    var endereco : String? = null
    var tipo : String? = null
    fun toOng() = Ong(endereco!!,  telefone!!,name!!, email!!, tipo!!)
}
fun Ong.toFBOng() : FBOng {
    val fbOng= FBOng()
    fbOng.name = this.name
    fbOng.email = this.email
    fbOng.endereco = this.endereco
    fbOng.tipo = this.tipo
    fbOng.telefone = this.telefone

    return fbOng
}
