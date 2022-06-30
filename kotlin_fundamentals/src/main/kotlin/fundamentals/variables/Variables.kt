package section_01_fundamentals.fundamentals.variables

fun main() {
    val name: String = "Adrian"
    println(name)
    // name = "another name" that's not possible since val is immutable

    var name2 : String = "Eduardo"
    name2 = "another name"
    println(name2)

    var age = 29;
    println(age)

    var salary = 3000L
    println(salary)

    val course = "Kotlin Spring Boot"
    println("course: $course and the course length is ${course.length}") // String interpolation

    val multiLine = " ABC \n DEF"
    println(multiLine)

    val multiLine2 = """ABC
        EDF
        """.trimIndent()
    println(multiLine2)
}