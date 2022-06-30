package section_01_fundamentals.fundamentals.class_interface_inheritance.inheritance

open class User(val name: String) {

    open var isLoggedIn: Boolean = false

    open fun login() {
        println("Inside user login")
    }
}

class Student(name: String) : User(name) {
    override var isLoggedIn = true
    override fun login() {
        super.login()
        println("Inside student login")
    }
}

class Instructor(name: String) : User(name) {}

fun main() {
    val student = Student("Adrian")
    println("Name is ${student.name}")
    student.login()
    println("Logged in values is : ${student.isLoggedIn}")

    val instructor = Instructor("Eduardo")
    println("Name is ${student.name}")
    instructor.login()

}