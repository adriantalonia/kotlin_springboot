package section_01_fundamentals.fundamentals.collections

fun main() {

    val courseList = courseList()

    val deSPredicate = { c: Course -> c.category == CourseCategory.DESIGN }

    exploreMap(courseList, deSPredicate)
}

fun exploreMap(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val courses = courseList
        .filter(predicate)
        .map { "${it.name} - ${it.category}" }
        .forEach {
            println(it)
        }
    println(courses)
}