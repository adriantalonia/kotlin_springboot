package section_01_fundamentals.fundamentals.collections

fun main() {

    val courseList = courseList()

    val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPEMENT }

    val deSPredicate = { c: Course -> c.category == CourseCategory.DESIGN }

    exploreFilter(courseList, deSPredicate)

}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    courseList
        //.filter { it.category == CourseCategory.DEVELOPEMENT }
        .filter { predicate.invoke(it) }
        .forEach {
            println("development course: $it")
        }

}