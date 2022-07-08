package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.InstructorDTO
import com.atr.kotlin_springboot_api.repository.InstructorRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class InstructorControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var instructorRepository: InstructorRepository

    @Test
    fun addInstructor() {

        var instructorDTO = InstructorDTO(null, "Andrew")

        var savedInstructor = webTestClient
            .post()
            .uri("/v1/instructors")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(InstructorDTO::class.java)
            .returnResult()
            .responseBody

        assertTrue { savedInstructor!!.id != null }

    }

    @Test
    fun addInstructor_Validation() {
        var instructorDTO = InstructorDTO(null, "")

        var reponse = webTestClient
            .post()
            .uri("/v1/instructors")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().isBadRequest
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        assertEquals("name must not be blank", reponse)
    }
}