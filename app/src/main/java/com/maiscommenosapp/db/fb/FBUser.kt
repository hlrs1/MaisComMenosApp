package com.maiscommenosapp.db.fb

import com.maiscommenosapp.model.User

class FBUser {
    var name : String ? = null
    var email : String? = null
    var endereco : String? = null
    var telefone : String? = null
    var tipo : String ?= null
    fun toUser() = User(name!!, email!!, endereco!!, telefone!!, tipo!!)
}
    fun User.toFBUser() : FBUser {
        val fbUser = FBUser()
        fbUser.name = this.name
        fbUser.email = this.email
        fbUser.endereco = this.endereco
        fbUser.telefone = this.telefone
        fbUser.tipo = this.tipo
        return fbUser
    }
