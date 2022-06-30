package section_01_fundamentals.fundamentals.scope_functions

fun main() {
    exploreWith()

    exploreRun()
}


fun exploreWith() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    val result = with(numbers) {
        /*println("Size is ${numbers.size}")
        numbers.plus(6)
        numbers.sum()*/

        println("Size is $size")
        val list = numbers.plus(6)
        list.sum()
    }
    println("With result = $result")
}

fun exploreRun() {
    var numbers: MutableList<Int>? = null
    var result = numbers.run {
        numbers = mutableListOf(1, 2, 3)
        numbers?.sum()
    }

    println("With result is: $result")

    val length = run {
        val name = "Adrian"
        println(name)
        name.length
    }

    println("Run length is: $length")
}
