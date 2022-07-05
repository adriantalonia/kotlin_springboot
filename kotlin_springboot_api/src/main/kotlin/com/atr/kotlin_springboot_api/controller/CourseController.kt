package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.CourseDTO
import com.atr.kotlin_springboot_api.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDTO): CourseDTO {
        return courseService.addCourse(courseDTO)
    }

    @GetMapping
    fun retrieveAllCourses(): List<CourseDTO> = courseService.retrieveAllCourses()

    @GetMapping("/{id}")
    fun retrieveCourseById(@PathVariable id: Int): CourseDTO? = courseService.getCourseById(id)

    @PutMapping("/{id}")
    fun updateCourse(@PathVariable id: Int, @RequestBody courseDTO: CourseDTO): CourseDTO {
        return courseService.updateCourse(id, courseDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable id: Int) {
        courseService.deleteCourse(id)
    }
}