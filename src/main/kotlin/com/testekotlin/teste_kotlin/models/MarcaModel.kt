package com.testekotlin.teste_kotlin.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "TB_MARCA")
class MarcaModel : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(nullable = false, unique = true)
    var nomeMarca: String? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    val modelos: MutableSet<ModeloModel> = HashSet()
}