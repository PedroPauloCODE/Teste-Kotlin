package com.testekotlin.teste_kotlin.models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "TB_CARRO")
class CarModel : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(nullable = false)
    var ano: Int? = null

    var combustivel: String? = null
    var numPortas: Int? = null
    var cor: String? = null

    @Column(nullable = false, updatable = false)
    var timestampCadastro: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    @JsonBackReference
    var modelo: ModeloModel? = null

    @PrePersist
    fun prePersist() {
        timestampCadastro = LocalDateTime.now()
    }
}
