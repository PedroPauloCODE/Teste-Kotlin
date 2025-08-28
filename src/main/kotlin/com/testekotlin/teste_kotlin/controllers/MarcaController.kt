package com.testekotlin.teste_kotlin.controllers

import com.testekotlin.teste_kotlin.dtos.MarcaRecordDto
import com.testekotlin.teste_kotlin.models.MarcaModel
import com.testekotlin.teste_kotlin.repositories.MarcaRepository
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/marca")
class MarcaController(
    private val marcaRepository: MarcaRepository
) {

    @PostMapping
    fun saveMarca(@RequestBody @Validated marcaRecordDto: MarcaRecordDto): ResponseEntity<MarcaModel> {
        val marcaModel = MarcaModel()
        marcaModel.nomeMarca = marcaRecordDto.nomeMarca
        val savedMarca = marcaRepository.save(marcaModel)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMarca)
    }

    @GetMapping
    fun getAllMarcas(): ResponseEntity<List<MarcaModel>> {
        val marcas = marcaRepository.findAll()
        return ResponseEntity.ok(marcas)
    }

    @PutMapping("/{id}")
    fun updateMarca(
        @PathVariable id: UUID,
        @RequestBody @Validated marcaRecordDto: MarcaRecordDto
    ): ResponseEntity<Any> {
        val marcaOptional = marcaRepository.findById(id)
        if (marcaOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.")
        }
        val marcaModel = marcaOptional.get()
        BeanUtils.copyProperties(marcaRecordDto, marcaModel)
        val updatedMarca = marcaRepository.save(marcaModel)
        return ResponseEntity.ok(updatedMarca)
    }

    @DeleteMapping("/{id}")
    fun deleteMarca(@PathVariable id: UUID): ResponseEntity<Any> {
        val marcaOptional = marcaRepository.findById(id)
        if (marcaOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada.")
        }
        marcaRepository.delete(marcaOptional.get())
        return ResponseEntity.ok("Marca deletada com sucesso!")
    }
}