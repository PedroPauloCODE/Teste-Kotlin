package com.testekotlin.teste_kotlin.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.UUID

data class ModeloRecordDto(
    @field:NotBlank(message = "Insira um nome válido.")
    val nome: String,

    @field:NotNull(message = "Insira um valor válido.")
    @JsonProperty("valor_fipe")
    val valorFipe: BigDecimal,

    @field:NotNull(message = "Insira um Id de marca válido.")
    @JsonProperty("marca_id")
    val marcaId: UUID
)