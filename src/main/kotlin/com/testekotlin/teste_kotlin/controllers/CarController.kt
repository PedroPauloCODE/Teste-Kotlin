package com.testekotlin.teste_kotlin.controllers

import com.testekotlin.teste_kotlin.dtos.CarRecordDto
import com.testekotlin.teste_kotlin.dtos.CarResumeDto
import com.testekotlin.teste_kotlin.models.CarModel
import com.testekotlin.teste_kotlin.repositories.CarRepository
import com.testekotlin.teste_kotlin.repositories.ModeloRepository
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cars")
class CarController(
    private val carRepository: CarRepository,
    private val modeloRepository: ModeloRepository
) {

    @PostMapping
    fun saveCar(@RequestBody @Validated carRecordDto: CarRecordDto): ResponseEntity<Any> {
        val modeloOptional = modeloRepository.findById(carRecordDto.modeloId)
        if (modeloOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.")
        }

        val carModel = CarModel()
        BeanUtils.copyProperties(carRecordDto, carModel)
        carModel.modelo = modeloOptional.get()

        val savedCar = carRepository.save(carModel)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar)
    }

    @GetMapping
    fun getCars(): ResponseEntity<List<CarResumeDto>> {
        val cars = carRepository.findAllResumo()
        return ResponseEntity.ok(cars)
    }

    @PutMapping("/{id}")
    fun updateCar(
        @PathVariable id: UUID,
        @RequestBody @Validated carRecordDto: CarRecordDto
    ): ResponseEntity<Any> {

        val carOptional = carRepository.findById(id)
        if (carOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado.")
        }

        val car = carOptional.get()

        // Atualiza os campos simples
        car.ano = carRecordDto.ano
        car.combustivel = carRecordDto.combustivel
        car.numPortas = carRecordDto.numPortas
        car.cor = carRecordDto.cor

        val modeloOptional = modeloRepository.findById(carRecordDto.modeloId)
        if (modeloOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado.")
        }
        car.modelo = modeloOptional.get()

        val updatedCar = carRepository.save(car)
        return ResponseEntity.ok(updatedCar)
    }

    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable id: UUID): ResponseEntity<Any> {
        val carOptional = carRepository.findById(id)
        if (carOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.")
        }
        carRepository.delete(carOptional.get())
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted successfully")
    }
}
