package section_01_fundamentals.fundamentals.casting

import section_01_fundamentals.fundamentals.class_interface_inheritance.Course

fun main() {

    val course = Course(10, "Math", "Eduardo")
    checkType(course);
    checkType("TEST");

    castNumber(10.55)
    //castNumber(10 )

    val number = 10
    val numberDouble = number.toDouble()
    castNumber(numberDouble)

}

fun checkType(type: Any) {
    when (type) {
        is Course -> {
            println(type)
        }
        is String -> {
            println(type.lowercase())
        }
    }
}

fun castNumber(any: Any) {
    when(any) {
        any as Double -> println("Value is double")
    }
}