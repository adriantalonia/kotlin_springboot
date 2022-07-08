package com.atr.kotlin_springboot_api.service

import com.atr.kotlin_springboot_api.dto.CourseDTO
import com.atr.kotlin_springboot_api.entity.Course
import com.atr.kotlin_springboot_api.exception.CourseNotFoundException
import com.atr.kotlin_springboot_api.exception.InstructorNotValidException
import com.atr.kotlin_springboot_api.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository, val instructorService: InstructorService) {

    companion object : KLogging()

    fun addCourse(courseDTO: CourseDTO): CourseDTO {

        val instructorOptional = instructorService.findByInstructorId(courseDTO.instructorId!!)

        if (!instructorOptional.isPresent) {
            throw InstructorNotValidException("Instructor not valid for the id: ${courseDTO.instructorId}")
        }

        var courseEntity = courseDTO.let {
            Course(null, it.name, it.category, instructorOptional.get())
        }

        courseRepository.save(courseEntity)

        logger.info("Saved course is: $courseEntity")

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category, it.instructor?.id)
        }

    }

    fun retrieveAllCourses(courseName: String?): List<CourseDTO> {

        val courses = courseName?.let {
            courseRepository.findCoursesByName(courseName)
        } ?: courseRepository.findAll()


        return courses.map {
            CourseDTO(it.id, it.name, it.category, it.instructor!!.id)
        }

        /*return courseRepository.findAll().map {
            CourseDTO(it.id, it.name, it.category)
        }*/
    }

    fun getCourseById(id: Int): CourseDTO? {
        return courseRepository.findById(id).let {
            if (it.isPresent) {
                val course = it.get()
                return CourseDTO(course.id, course.name, course.category, course.instructor!!.id)
            } else {
                return null
            }
        }
    }

    fun updateCourse(id: Int, courseDTO: CourseDTO): CourseDTO {
        val existingCourse = courseRepository.findById(id)
        return if (existingCourse.isPresent) {
            existingCourse.get().let {
                it.name = courseDTO.name
                it.category = courseDTO.category
                courseRepository.save(it)
                CourseDTO(it.id, it.name, it.category)
            }
        } else {
            throw CourseNotFoundException("No course found for id: $id.")
        }
    }

    fun deleteCourse(id: Int) {
        val existingCourse = courseRepository.findById(id)
        if (existingCourse.isPresent) {
            courseRepository.deleteById(id)

        } else {
            throw CourseNotFoundException("No course found for id: $id.")
        }
    }

}
