package section_01_fundamentals.fundamentals.ranges_loops

fun main() {

    val range = 1..10
    for (i in range) {
        println("i: $i")
    }

    val reverseRange = 10 downTo 1
    for (i in reverseRange) {
        println("reverseRange : $i")
    }

    for (i in reverseRange step 2) {
        println("reverseRange : $i")
    }
}