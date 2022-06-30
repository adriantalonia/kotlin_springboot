package section_01_fundamentals.fundamentals.class_interface_inheritance.task

data class Employee(val id: Int, val name: String) {
}

fun main() {
    var employee = Employee(1, "Adrian")
    println(employee)

    var employee2 = Employee(1, "Adrian")
    println("both object are the same? ${employee == employee2}")

    var employee3 = employee2.copy(id = 2, name = "Another")
    println(employee3)
}