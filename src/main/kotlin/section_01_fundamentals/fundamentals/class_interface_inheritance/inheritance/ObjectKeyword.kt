package section_01_fundamentals.fundamentals.class_interface_inheritance.inheritance

object Authenticate {
    fun authenticate(userName: String, password: String) {
        println("User authenticate for userName : $userName")
    }
}

fun main() {
    Authenticate.authenticate("Adrian", "password")
}