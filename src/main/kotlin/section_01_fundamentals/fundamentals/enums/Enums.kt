package section_01_fundamentals.fundamentals.enums

enum class Category {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

fun main() {
    val category = Category.BUSINESS
    println(category)
}