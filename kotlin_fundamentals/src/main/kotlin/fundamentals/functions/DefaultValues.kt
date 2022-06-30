package section_01_fundamentals.fundamentals.functions

import java.time.LocalDate

fun main() {
    printPersonDetails("Adrian", "test@mail.com", LocalDate.now())
    printPersonDetails("Eduardo")
    printPersonDetails(name = "Test")
    printPersonDetails(name = "Test2", dob = LocalDate.now())
    printPersonDetails(dob = LocalDate.now(), name = "Test3", email = "test@gmail.com")

}

fun printPersonDetails(
    name: String,
    email: String = "",
    dob: LocalDate = LocalDate.now()
) {
    println("Name is $name and the email is $email and the dob is $dob")
}