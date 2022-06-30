package section_01_fundamentals.fundamentals.exceptions

fun main() {

    println("Name length is ${nameLength("Adrian")}")

    println("Name length is ${nameLength(null)}")

    returnNothing()

}

fun nameLength(name: String?): Int? {
    val result = try {
        name!!.length
    } catch (ex: Exception) {
        println("Exception is: $ex")
        null
    }
    return result
}

fun returnNothing(): Nothing {
    throw RuntimeException("Exception")
}