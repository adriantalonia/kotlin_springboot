package com.atr.kotlin_springboot_api.repository

import com.atr.kotlin_springboot_api.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int> {
    fun findByNameContaining(name: String): List<Course>

    @Query(value = "SELECT * FROM COURSES where name like %?1%", nativeQuery = true)
    fun findCoursesByName(courseName: String): List<Course>
}