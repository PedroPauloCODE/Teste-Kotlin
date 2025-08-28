package com.testekotlin.teste_kotlin.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "TB_MODELO")
class ModeloModel : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(name = "name", nullable = false, unique = true)
    var nome: String = ""

    @Column(nullable = false)
    var valorFipe: BigDecimal = BigDecimal.ZERO

    @ManyToOne
    @JoinColumn(name = "marca_id")
    var marca: MarcaModel? = null

    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY)
    @JsonIgnore
    val carros: MutableSet<CarModel> = HashSet()
}

