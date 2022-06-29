package section_01_fundamentals.fundamentals.collections

fun main() {
    val namesListSequence = listOf("alex", "ben", "chloe")
        .asSequence()
        .filter { it.length > 4 }
        .map { it.uppercase() }
        .toList()

    println("Names: $namesListSequence")

    val courseList = courseList()
    val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPEMENT }
    exploreFilterSequence(courseList, devPredicate)

    val range = 1..1000_000
    range
        .asSequence()
        .map { it.toDouble() }
        .take(40)
        .forEach {
            println("Value is: $it")
        }
}

fun exploreFilterSequence(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    courseList
        .asSequence()
        .filter { predicate.invoke(it) }
        .forEach {
            println("development course: $it")
        }

}