package com.maiscommenosapp.model

data class Produto (
    val name : String,
    val quantidade: Int? = null,
    val preco: Double? = null
)