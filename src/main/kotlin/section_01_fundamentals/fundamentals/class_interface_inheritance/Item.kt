package section_01_fundamentals.fundamentals.class_interface_inheritance

class Item() {
    var name: String = ""

    constructor(_name: String) : this() { // secondary constructor
        name = _name
    }
}

fun main() {
    val item = Item("laptop")
    println("Item name is ${item.name}")
    item.name = "iphone"
    println("Item name is ${item.name}")
}