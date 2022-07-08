package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.CourseDTO
import com.atr.kotlin_springboot_api.entity.Course
import com.atr.kotlin_springboot_api.repository.CourseRepository
import com.atr.kotlin_springboot_api.repository.InstructorRepository
import com.atr.kotlin_springboot_api.util.courseEntityList
import com.atr.kotlin_springboot_api.util.instructorEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.util.UriComponentsBuilder


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Autowired
    lateinit var instructorRepository: InstructorRepository

    @BeforeEach
    fun setUp() {
        courseRepository.deleteAll()
        val instructor = instructorEntity()
        instructorRepository.save(instructor)
        val courses = courseEntityList(instructor)
        courseRepository.saveAll(courses)
    }

    @Test
    fun addCourse() {

        val instructor = instructorRepository.findAll().first()

        var courseDTO = CourseDTO(null, "BUild Resfult APIs using Springboot and Kotlin", "Development", instructor.id)

        var savedCourseDTO = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertTrue {
            savedCourseDTO!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {

        val uri = UriComponentsBuilder.fromUriString("/v1/courses")
            .queryParam("name", null)
            .toUriString()

        val courseDTOs = webTestClient.get()
            .uri(uri)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(3, courseDTOs!!.size)
    }

    @Test
    fun retrieveAllCoursesByName() {

        val uri = UriComponentsBuilder.fromUriString("/v1/courses")
            .queryParam("name", "SpringBoot")
            .toUriString()

        val courseDTOs = webTestClient.get()
            .uri(uri)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(2, courseDTOs!!.size)
    }

    @Test
    fun retrieveCourseById() {
        val courseDTO = webTestClient.get()
            .uri("/v1/courses/2")
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(2, courseDTO!!.id)
    }

    @Test
    fun updateCourseTest() {

        val instructor = instructorRepository.findAll().first()

        val course = Course(
            null,
            "Build RestFul APis using SpringBoot and Kotlin", "Development", instructor
        )
        courseRepository.save(course)

        val updateCourseDTO = CourseDTO(
            null,
            "Build Kotlin", "Development 2", instructor.id
        )

        var updatedCourse = webTestClient
            .put()
            .uri("/v1/courses/{id}", course.id)
            .bodyValue(updateCourseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Build Kotlin", updatedCourse!!.name)

    }

    @Test
    fun deleteCourseTest() {
        val instructor = instructorRepository.findAll().first()

        val course = Course(
            null,
            "Build RestFul APis using SpringBoot and Kotlin", "Development", instructor
        )
        courseRepository.save(course)


        var updatedCourse = webTestClient
            .delete()
            .uri("/v1/courses/{id}", course.id)
            .exchange()
            .expectStatus().isNoContent

    }

}