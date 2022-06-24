package section_01_fundamentals.fundamentals.class_interface_inheritance

class Person(
    val name: String = "",
    val age: Int = 0
) {// primary constructor

    var email: String = ""

    //secundary constructor
    constructor(_email: String, _name: String = "", _age: Int = 0) : this(_name, _age) {
        email = _email
    }

    var nameLength: Int = 0

    // initizializer block
    init {
        println("Inside init block")
        nameLength = name.length
    }

    fun action() {
        println("Person walks")
    }
}

fun main() {
    val person = Person("Adrian", 29)
    person.action()
    println("Name: ${person.name} is ${person.age} age")

    val person2 = Person()
    println("Name: ${person2.name} is ${person2.age} age")

    val person3 = Person(_email = "abc@mail.com")
    println("Name: ${person3.name} is ${person3.age} age and email is ${person3.email}")

    val person4 = Person(_email = "abc@mail.com", _name = "Test4", _age = 25)
    println("Name: ${person4.name} is ${person4.age} age and email is ${person4.email} and the name length ${person4.nameLength}")


}
