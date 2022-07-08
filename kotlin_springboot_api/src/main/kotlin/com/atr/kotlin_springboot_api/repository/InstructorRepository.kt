package com.atr.kotlin_springboot_api.repository

import com.atr.kotlin_springboot_api.entity.Instructor
import org.springframework.data.repository.CrudRepository

interface InstructorRepository : CrudRepository<Instructor, Int> {

}