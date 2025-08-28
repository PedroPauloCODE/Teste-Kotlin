package com.testekotlin.teste_kotlin.repositories

import com.testekotlin.teste_kotlin.models.MarcaModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MarcaRepository : JpaRepository<MarcaModel, UUID>