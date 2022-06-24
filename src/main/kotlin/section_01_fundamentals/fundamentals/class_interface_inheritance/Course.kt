package section_01_fundamentals.fundamentals.class_interface_inheritance

data class Course(
    val id: Int,
    val name: String,
    val author: String
) {
}

fun main() {
    val course = Course(1, "Reactive Programming", "Adrian")

    println(course)
}