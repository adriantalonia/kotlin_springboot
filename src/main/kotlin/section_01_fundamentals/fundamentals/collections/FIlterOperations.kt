package section_01_fundamentals.fundamentals.collections

fun main() {

    val courseList = courseList()

    exploreFilter(courseList)

}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    var developmentCourses = courseList.filter {
        it.category == CourseCategory.DEVELOPEMENT
    }.forEach {
        println("development course: $it")
    }

}