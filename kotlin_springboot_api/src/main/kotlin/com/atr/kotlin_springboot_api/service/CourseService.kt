package com.atr.kotlin_springboot_api.service

import com.atr.kotlin_springboot_api.dto.CourseDTO
import com.atr.kotlin_springboot_api.entity.Course
import com.atr.kotlin_springboot_api.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object: KLogging()

    fun addCourse(courseDTO: CourseDTO): CourseDTO {

        var courseEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }

        courseRepository.save(courseEntity)

        logger.info("Saved course is: $courseEntity")

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }

    }

}
