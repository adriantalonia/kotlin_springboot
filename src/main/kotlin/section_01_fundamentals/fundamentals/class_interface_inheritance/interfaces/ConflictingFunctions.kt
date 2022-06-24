package section_01_fundamentals.fundamentals.class_interface_inheritance.interfaces

interface A {
    fun doSomething() {
        println("Do something in A")
    }
}

interface B {
    fun doSomething() {
        println("Do something in B")
    }
}

class AB : A, B {

    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("doSomething in AB")
    }

}

fun main() {
    val ab = AB()
    ab.doSomething()
}