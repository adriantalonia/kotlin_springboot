package section_01_fundamentals.fundamentals.collections

fun main() {
    val courseList = courseList()
    exploreHashMap()
}

fun exploreHashMap() {
    val nameAgeMutableMap = mutableMapOf("Adrian" to 29, "Eduardo" to 27)

    nameAgeMutableMap.forEach { (k, v) ->
        println("Key: $k and the value is $v")
    }

    //val value = nameAgeMutableMap["Adrian"]
    val value = nameAgeMutableMap.getOrElse("Eduardo") { "default" }
    println("Value is $value")

    val result = nameAgeMutableMap.containsKey("Adrian") // return true
    println("Result = $result")

    val filterMap = nameAgeMutableMap.filterKeys { it.length > 3 }
        .map { it.key.uppercase() }
    println("FilterMap = $filterMap")

    val maxValue = nameAgeMutableMap.maxByOrNull { it.value }
    println("MaxValue = $maxValue")

}