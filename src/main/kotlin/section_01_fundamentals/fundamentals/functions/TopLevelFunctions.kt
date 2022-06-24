package section_01_fundamentals.fundamentals.functions

fun main() {
    val num = topLevelFunction()
    println("Number $num")
}

fun topLevelFunction(): Int {
    return (0..100).random()
}

const val courseName = "Kotlin Programming"