package com.atr.kotlin_springboot_api.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CourseDTO(
    val id: Int?,
    @get:NotBlank(message = "name must not be blank")
    val name: String,
    @get:NotBlank(message = "category must not be blank")
    val category: String,
    @get:NotNull(message = "instructor must not be null")
    val instructorId: Int? = null
)