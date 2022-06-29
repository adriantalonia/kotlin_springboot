package section_01_fundamentals.fundamentals.collections

fun main() {

    val courseList = courseList()
    val list = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
    val mapResult = list.map { outerList ->
        outerList.map {
            it.toDouble()
        }
    }
    println("mapResult $mapResult")

    val flatMapResult = list.flatMap { outerList ->
        outerList.map {
            it.toDouble()
        }
    }
    println("flatMapResult $flatMapResult")

    val courses = exploreFlatMap(courseList, KAFKA)
    println("courses : $courses")
}

fun exploreFlatMap(courseList: MutableList<Course>, kafka: String): List<String> {
    val kafkaCourse = courseList.flatMap { course ->
        val courseName = course.name
        course.topicsCovered.filter { it == kafka }
            .map {
                courseName
            }
    }
    return kafkaCourse
}