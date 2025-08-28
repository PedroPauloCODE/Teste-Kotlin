package com.testekotlin.teste_kotlin.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

data class CarRecordDto(
    @field:NotNull(message = "Insira um ano válido.")
    val ano: Int,

    @field:NotBlank(message = "Insira um nome de combustível válido.")
    val combustivel: String,

    @field:NotNull(message = "Insira um nº válido.")
    @JsonProperty("num_portas")
    val numPortas: Int,

    @field:NotBlank(message = "Insira uma cor válida.")
    val cor: String,

    @field:NotNull(message = "Insira um Id de um Modelo válido.")
    @JsonProperty("modelo_id")
    val modeloId: UUID
)
