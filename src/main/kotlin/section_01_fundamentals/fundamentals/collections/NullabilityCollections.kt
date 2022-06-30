package section_01_fundamentals.fundamentals.collections

fun main() {

    var list: MutableList<String>? = null
    list = mutableListOf()
    list.add("Adrian")


    list.forEach {
        println("Value is: $it")
    }

    val list2: List<String?> = listOf("Adam", null, "Adrian")
    list2.forEach {
        println("Value length is: ${it?.length}")
    }

}