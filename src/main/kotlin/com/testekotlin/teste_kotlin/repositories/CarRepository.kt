package com.testekotlin.teste_kotlin.repositories

import com.testekotlin.teste_kotlin.dtos.CarResumeDto
import com.testekotlin.teste_kotlin.models.CarModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface CarRepository : JpaRepository<CarModel, UUID> {

    @Query("""
        SELECT new com.testekotlin.teste_kotlin.dtos.CarResumeDto(
            c.id,
            c.timestampCadastro,
            m.id,
            c.ano,
            c.combustivel,
            c.numPortas,
            c.cor,
            m.nome,
            m.valorFipe
        )
        FROM CarModel c
        JOIN c.modelo m
    """)
    fun findAllResumo(): List<CarResumeDto>
}
