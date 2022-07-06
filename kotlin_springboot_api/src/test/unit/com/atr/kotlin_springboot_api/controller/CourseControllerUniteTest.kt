package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.CourseDTO
import com.atr.kotlin_springboot_api.entity.Course
import com.atr.kotlin_springboot_api.service.CourseService
import com.atr.kotlin_springboot_api.util.courseDTO
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureWebTestClient
class CourseControllerUniteTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMock: CourseService

    @Test
    fun addCourse() {
        var courseDTO = CourseDTO(null, "BUild Resfult APIs using Springboot and Kotlin", "Development")

        every { courseServiceMock.addCourse(any()) } returns courseDTO(id = 1)

        var savedCourseDTO = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            savedCourseDTO!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {

        every { courseServiceMock.retrieveAllCourses() }.returnsMany(
            listOf(
                courseDTO(id = 1),
                courseDTO(id = 2, name = "Javascript")
            )
        )

        val courseDTOs = webTestClient.get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(2, courseDTOs!!.size)
    }

    @Test
    fun retrieveCourseById() {

        every { courseServiceMock.getCourseById(any()) } returns courseDTO(id = 1)

        val courseDTO = webTestClient.get()
            .uri("/v1/courses/1")
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(1, courseDTO!!.id)
    }

    @Test
    fun updateCourseTest() {

        every { courseServiceMock.updateCourse(any(), any()) } returns courseDTO(id = 100, name="Build Kotlin")

        val updateCourseDTO = CourseDTO(
            null,
            "Build Kotlin", "Development 2"
        )

        var updatedCourse = webTestClient
            .put()
            .uri("/v1/courses/{id}", 100)
            .bodyValue(updateCourseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals("Build Kotlin", updatedCourse!!.name)

    }

    @Test
    fun deleteCourseTest() {

        every { courseServiceMock.deleteCourse(any())} just runs

        var updatedCourse = webTestClient
            .delete()
            .uri("/v1/courses/{id}", 100)
            .exchange()
            .expectStatus().isNoContent

    }


}
