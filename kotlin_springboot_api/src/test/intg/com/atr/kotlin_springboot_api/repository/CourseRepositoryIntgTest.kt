package com.atr.kotlin_springboot_api.repository

import com.atr.kotlin_springboot_api.util.courseEntityList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.util.stream.Stream

@DataJpaTest
@ActiveProfiles("test")
class CourseRepositoryIntgTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setup() {
        courseRepository.deleteAll()
        val courses = courseEntityList()
        courseRepository.saveAll(courses)
    }

    @Test
    fun findByNameContaining() {

        val courses = courseRepository.findByNameContaining("SpringBoot")
        println("courses: $courses")

        assertEquals(2, courses.size)
    }

    @Test
    fun findCoursesByName() {

        val courses = courseRepository.findCoursesByName("SpringBoot")
        println("courses: $courses")

        assertEquals(2, courses.size)
    }

    @ParameterizedTest
    @MethodSource("courseAndSize")
    fun findByNameContainingUsingParams(name: String, expectedSize: Int) {

        val courses = courseRepository.findByNameContaining(name)
        println("courses: $courses")

        assertEquals(expectedSize, courses.size)
    }

    companion object {
        @JvmStatic
        fun courseAndSize(): Stream<Arguments> {
            return Stream.of(Arguments.arguments("SpringBoot", 2), Arguments.arguments("Wiremock", 1))
        }
    }
}