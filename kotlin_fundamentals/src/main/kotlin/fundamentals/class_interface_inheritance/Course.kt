package section_01_fundamentals.fundamentals.class_interface_inheritance

data class Course(
    val id: Int,
    val name: String,
    val author: String
) {
}

fun main() {
    val course = Course(1, "Reactive Programming", "Adrian")
    val course1 = Course(1, "Reactive Programming", "Adrian")

    println(course)

    println("Checking Object equality: ${course == course1}")

    val course3 = course1.copy(id = 2, author = "Eduardo")

    println(course3)
}