package section_01_fundamentals.fundamentals.class_interface_inheritance.inheritance

class Test {
    companion object {
        const val dollar = 10
        fun country() = "USA"
    }
}

fun main() {
    println("Country name: ${Test.country()} and dollars ${Test.dollar}")
}