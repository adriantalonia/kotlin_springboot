package com.atr.kotlin_springboot_api.repository

import com.atr.kotlin_springboot_api.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int> {

}