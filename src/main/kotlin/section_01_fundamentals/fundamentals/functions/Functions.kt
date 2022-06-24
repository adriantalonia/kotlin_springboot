package section_01_fundamentals.fundamentals.functions

fun main() {
    printName("Adrian")
    val result = addition(1,2)
    println(result)

    val result1 = additionApproach(1,2)
    println(result1)
}

fun printName(s: String) {
    println("Name is: $s")
}

fun addition(x: Int, y: Int): Int {
    return x + y
}

fun additionApproach(x: Int, y: Int) = x + y