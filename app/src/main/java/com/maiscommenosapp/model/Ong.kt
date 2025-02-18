package com.maiscommenosapp.model

data class Ong(
    override val endereco: String,
    override val telefone: String,
    override val name: String,
    override val email: String,
    override val tipo: String
) : User(
    name,
    email,
    endereco,
    telefone,
    tipo
)
