package section_01_fundamentals.fundamentals.scope_functions

fun main() {
    exploreLet()
}

fun exploreLet() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    val result = numbers.map { it * 2 }.filter { it > 5 }
        .let {
            println(it)
            it.sum()
        }
    println(result)

    var name: String? = null
    name = "Test"
    var result1 = name?.let {
        println(it)
        it.uppercase()
    }

    println(result1)
}
