package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.InstructorDTO
import com.atr.kotlin_springboot_api.service.InstructorService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/v1/instructors")
class InstructorController(val instructorService: InstructorService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createInstructor(@RequestBody @Valid instructorDTO: InstructorDTO) = instructorService.createInstructor(instructorDTO)
}