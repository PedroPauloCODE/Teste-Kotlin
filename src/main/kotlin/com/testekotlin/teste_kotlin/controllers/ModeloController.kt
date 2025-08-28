package com.testekotlin.teste_kotlin.controllers

import com.testekotlin.teste_kotlin.dtos.ModeloRecordDto
import com.testekotlin.teste_kotlin.models.ModeloModel
import com.testekotlin.teste_kotlin.repositories.MarcaRepository
import com.testekotlin.teste_kotlin.repositories.ModeloRepository
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/modelos")
class ModeloController(
    private val modeloRepository: ModeloRepository,
    private val marcaRepository: MarcaRepository
) {

    @PostMapping
    fun saveModelos(@RequestBody @Validated modeloRecordDto: ModeloRecordDto): ResponseEntity<Any> {
        val marcaOptional = marcaRepository.findById(modeloRecordDto.marcaId)
        if (marcaOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.")
        }

        val modeloModel = ModeloModel()
        BeanUtils.copyProperties(modeloRecordDto, modeloModel)
        modeloModel.marca = marcaOptional.get()

        val savedModelo = modeloRepository.save(modeloModel)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedModelo)
    }

    @GetMapping
    fun getAllModelo(): ResponseEntity<List<ModeloModel>> {
        val modelos = modeloRepository.findAll()
        return ResponseEntity.ok(modelos)
    }

    @PutMapping("/{id}")
    fun updateModelo(
        @PathVariable id: UUID,
        @RequestBody @Validated modeloRecordDto: ModeloRecordDto
    ): ResponseEntity<Any> {
        val modeloOptional = modeloRepository.findById(id)
        if (modeloOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.")
        }

        val marcaOptional = marcaRepository.findById(modeloRecordDto.marcaId)
        if (marcaOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.")
        }

        val modelo = modeloOptional.get()
        BeanUtils.copyProperties(modeloRecordDto, modelo, "id", "marca")
        modelo.marca = marcaOptional.get()

        val updatedModelo = modeloRepository.save(modelo)
        return ResponseEntity.ok(updatedModelo)
    }

    @DeleteMapping("/{id}")
    fun deleteModelo(@PathVariable id: UUID): ResponseEntity<Any> {
        val modeloOptional = modeloRepository.findById(id)
        if (modeloOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.")
        }
        modeloRepository.delete(modeloOptional.get())
        return ResponseEntity.ok("Modelo deletado com sucesso!")
    }
}
