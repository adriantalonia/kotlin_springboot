package com.atr.kotlin_springboot_api.dto

import javax.validation.constraints.NotBlank

data class InstructorDTO(
    val id: Int?,
    @get:NotBlank(message = "name must not be blank")
    var name: String
)