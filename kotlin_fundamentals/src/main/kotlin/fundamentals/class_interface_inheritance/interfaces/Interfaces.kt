package section_01_fundamentals.fundamentals.class_interface_inheritance.interfaces

import section_01_fundamentals.fundamentals.class_interface_inheritance.Course

interface CourseRepository {
    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("course: $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): Any
}

class SqlCourseRepository : CourseRepository, Repository {
    override fun getById(id: Int): Course {
        return Course(id, "Spring boot", "Adrian")
    }

    override fun getAll(): Any {
        return 1
    }
}

class NoSqlRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(id, "Mongo course", "Eduardo")
    }

    override fun save(course: Course): Int {
        println("course in NoSQLCourse: $course")
        return course.id
    }
}

fun main() {
    val repoSQL = SqlCourseRepository()

    val course = repoSQL.getById(1)
    println(course)
    val courseId = repoSQL.save(course)
    println("Saved courseId: $courseId")

    val repoNoSQL = NoSqlRepository()

    val course2 = repoNoSQL.getById(2)
    println(course2)
    val courseId2 = repoNoSQL.save(course2)
    println("Saved courseId: $courseId2")
}