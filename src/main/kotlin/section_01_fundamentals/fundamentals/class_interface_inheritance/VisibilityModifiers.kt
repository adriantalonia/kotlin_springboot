package section_01_fundamentals.fundamentals.class_interface_inheritance

open class Example() {
    private fun secret() {
        println("Secret function")
    }

    protected open fun logout() {
        println("protected function")
    }
}

class ExampleChild() : Example() {
    public override fun logout() {
        super.logout()
        println("Inside ExampleChild protected function")
    }
}

fun main() {
    val example = Example()
    //example.secret is not visible since it's private

    //example.logout is not visible only to child classes
    val exampleChild = ExampleChild()
    exampleChild.logout()
}