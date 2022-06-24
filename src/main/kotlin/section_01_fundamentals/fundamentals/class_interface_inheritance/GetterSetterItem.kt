package section_01_fundamentals.fundamentals.class_interface_inheritance

class GetterSetterItem() {
    var name: String = ""
    var price: Double = 0.0
        //get() = field
        get() {
            println("Inside getter")
            return field
        }
        set(value) {
            println("Inside setter")
            if (value > 0.0) {
                field = value
            } else {
                throw IllegalAccessException("Negative price is not Allowed!")
            }
        }

    constructor(_name: String) : this() { // secondary constructor
        name = _name
    }
}

fun main() {
    val item = GetterSetterItem("laptop")
    println("Item name is ${item.name}")
    item.name = "iphone"
    println("Item name is ${item.name}")

    item.price = 10.0
    println(item.price)
}