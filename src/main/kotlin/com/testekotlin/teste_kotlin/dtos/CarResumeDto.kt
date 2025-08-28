package com.testekotlin.teste_kotlin.dtos

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class CarResumeDto(
    val id: UUID,
    val timestampCadastro: LocalDateTime,
    val modeloId: UUID,
    val ano: Int,
    val combustivel: String,
    val numPortas: Int,
    val cor: String,
    val nomeModelo: String,
    val valor: BigDecimal
)
