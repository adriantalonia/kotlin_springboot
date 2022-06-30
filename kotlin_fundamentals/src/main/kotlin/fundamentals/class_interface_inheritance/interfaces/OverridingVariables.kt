package section_01_fundamentals.fundamentals.class_interface_inheritance.interfaces

interface Test01 {
    var isTrue: Boolean
}

class Tester : Test01 {
    override var isTrue: Boolean = false
}

fun main() {
    val tester = Tester()
    println("is true: ${tester.isTrue}")
}