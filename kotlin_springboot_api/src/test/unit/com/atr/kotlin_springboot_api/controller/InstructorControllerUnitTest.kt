package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.InstructorDTO
import com.atr.kotlin_springboot_api.service.InstructorService
import com.atr.kotlin_springboot_api.util.courseDTO
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [InstructorController::class])
@AutoConfigureWebTestClient
class InstructorControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var instructorServiceMock: InstructorService

    @Test
    fun addInstructor() {
        var instructorDTO = InstructorDTO(null, "Andrew")

        every { instructorServiceMock.createInstructor(any()) } returns instructorDTO(id = 1)

        var savedInstructor = webTestClient
            .post()
            .uri("/v1/instructors")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(InstructorDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue { savedInstructor!!.id != null }
    }

    private fun instructorDTO(id: Int? = null, name: String = "Andrew") = InstructorDTO(id, name)

}