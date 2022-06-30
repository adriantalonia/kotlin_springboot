package section_01_fundamentals.fundamentals.collections

fun main() {

    val names = listOf("Adrian", "Eduardo", "Erick")
    println("Names: $names")

    val namesMutableList = mutableListOf("Adrian", "Eduardo", "Erick")
    namesMutableList.add("Test") // add new elements
    println("namesMutableList: $namesMutableList")

    val set = setOf("Adrian", "Eduardo", "Erick", "Adrian")
    println("Set: $set")

    val setMutable = mutableSetOf("Adrian", "Eduardo", "Erick", "Adrian")
    setMutable.add("Eduardo")
    setMutable.add("Test")
    println("setMutable: $setMutable")

    val nameAgeMap = mapOf("Adrian" to 29, "Eduardo" to 26)
    println("Map: $nameAgeMap")

    val mutableNameAgeMap = mutableMapOf("Adrian" to 29, "Eduardo" to 26)
    mutableNameAgeMap["Test"] = 20
    println("mutableNameAgeMap: $mutableNameAgeMap")


}