package com.atr.kotlin_springboot_api.controller

import com.atr.kotlin_springboot_api.dto.CourseDTO
import com.atr.kotlin_springboot_api.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/courses")
@Validated
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody @Valid courseDTO: CourseDTO): CourseDTO {
        return courseService.addCourse(courseDTO)
    }

    /*@GetMapping
    fun retrieveAllCourses(): List<CourseDTO> = courseService.retrieveAllCourses()*/

    @GetMapping
    fun retrieveAllCourses(@RequestParam("name", required = false) courseName: String?): List<CourseDTO> {
        return courseService.retrieveAllCourses(courseName)
    }

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