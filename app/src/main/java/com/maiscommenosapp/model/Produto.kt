package com.maiscommenosapp.model

import java.util.Date

data class Produto (
    val name : String,
    val quantidade: Int? = null,
    val preco: Double? = null,
    val validade: Date
)