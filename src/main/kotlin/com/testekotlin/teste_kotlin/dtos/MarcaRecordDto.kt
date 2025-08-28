package com.testekotlin.teste_kotlin.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

data class MarcaRecordDto(
    @field:NotBlank(message = "O nome da marca não pode ser vazio")
    @JsonProperty("nome_marca")
    var nomeMarca: String
)
