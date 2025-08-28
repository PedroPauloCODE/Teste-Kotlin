package com.testekotlin.teste_kotlin.repositories

import com.testekotlin.teste_kotlin.models.ModeloModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ModeloRepository : JpaRepository<ModeloModel, UUID>
