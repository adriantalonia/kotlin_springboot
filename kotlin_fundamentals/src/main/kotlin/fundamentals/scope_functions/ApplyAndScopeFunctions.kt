package section_01_fundamentals.fundamentals.scope_functions

import section_01_fundamentals.fundamentals.collections.*

fun main() {
    exploreApply()

    exploreAlso()
}

fun exploreApply() {

    var course = CourseA(
        1,
        "Adrian Talonia"
    ).apply {
        courseCategory = CourseCategory.DESIGN
        //this.courseCategory = CourseCategory.DESIGN
    }

    println("Course: $course")
}

fun exploreAlso() {
    var course = CourseA(
        1,
        "Adrian Talonia"
    ).also {
        println("Course is $it")
    }
}

data class CourseA(
    val id: Int,
    val author: String,
    var courseCategory: CourseCategory = CourseCategory.DEVELOPEMENT
)