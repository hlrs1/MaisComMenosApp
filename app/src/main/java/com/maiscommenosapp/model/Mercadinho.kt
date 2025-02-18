package com.maiscommenosapp.model

data class Mercadinho(
    override val name :  String,
    override val email : String,
    override val tipo: String,
    val cnpj: String,
    override val endereco : String,
    override val telefone: String
) : User(
    name,
    email,
    endereco,
    telefone,
    tipo
    )


